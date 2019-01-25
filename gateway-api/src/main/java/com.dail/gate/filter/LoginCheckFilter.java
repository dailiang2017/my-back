package com.dail.gate.filter;

import com.dail.constant.CookieConstant;
import com.dail.constant.PrefixConstant;
import com.dail.constant.RedisConstant;
import com.dail.dto.CacheResult;
import com.dail.dto.TokenInfo;
import com.dail.gate.service.IgnoreUrlService;
import com.dail.util.RedisClient;
import com.dail.utils.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Auther: dailiang
 * @Date: 2018/12/27 17:38
 * @Description:
 */
@Slf4j
@Component
public class LoginCheckFilter extends ZuulFilter {

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private IgnoreUrlService ignoreUrlService;

    @Override
    public String filterType() {
        // pre：可以在请求被路由之前调用。
        // routing：在路由请求时候被调用。
        // post：在routing和error过滤器之后被调用。
        // error：处理请求时发生错误时被调用。
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 通过int值来定义过滤器的执行顺序，数值越小优先级越高。
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String requestUri = request.getRequestURI();
        // 访问的url是否可以忽略登录校验
        return !ignoreUrlService.loginCheckUrl(requestUri);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getMethod().equals(RequestMethod.OPTIONS)) {
            return null;
        }

        String token = request.getHeader(CookieConstant.COOKIE_NAME_TOKEN);
        if (StringUtil.isBlankOrEmpty(token)) {
            setUnauthorizedResponse(ctx);
            return null;
        }
        // 校验并设置token信息
        checkTokenInfo(ctx, token);
        return null;
    }

    private void checkTokenInfo(RequestContext requestContext, String token) {
        CacheResult<TokenInfo> result = redisClient.get(PrefixConstant.TOKEN_KEY + token, TokenInfo.class);
        if (result.getData() == null) {
            setResponseMsg(requestContext, "登录已过期！");
        } else {
            Long userid = result.getData().getId();
            CacheResult<String> uniqueToken = redisClient.get(PrefixConstant.USERID_KEY + userid, String.class);
            if (!token.equals(uniqueToken.getData())) {
                // 其他人登录此账号，被踢出登录，删除token缓存信息
                redisClient.delete(PrefixConstant.TOKEN_KEY + token);
                setResponseMsg(requestContext, "您的账号在其他地方登录，请检查密码是否泄漏！");
            } else {
                setTokenInfo(requestContext.getResponse(), token, result.getData());
                requestContext.addZuulRequestHeader(CookieConstant.USER_INFO_KEY, StringUtil.beanToString(result.getData()));
                requestContext.addZuulRequestHeader(CookieConstant.COOKIE_NAME_TOKEN, token);
            }
        }
    }

    /**
     * 设置token
     * @param response
     * @param token
     * @param user
     */
    private void setTokenInfo(HttpServletResponse response, String token, TokenInfo user) {
        // 保存token到redis缓存中
        redisClient.set(PrefixConstant.TOKEN_KEY + token, user, RedisConstant.tokenToExpireDefault);
    }

    /**
     *  设置无权限状态 401
     * @param requestContext
     */
    private void setUnauthorizedResponse(RequestContext requestContext) {
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        try {
            requestContext.setResponseBody(URLEncoder.encode("没有登录权限！", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     *  设置返回信息 401
     * @param requestContext
     */
    private void setResponseMsg(RequestContext requestContext, String msg) {
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        try {
            requestContext.setResponseBody(URLEncoder.encode(msg, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
