package com.dail.gate.filter;

import com.dail.dto.BaseResult;
import com.dail.utils.JsonUtil;
import com.dail.utils.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Auther: dailiang
 * @Date: 2019/1/15 10:20
 * @Description:
 */
@Slf4j
@Component
public class ResponseCheckFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            BaseResult baseResult = new BaseResult();
            // 获得返回值并加以处理
            String body = StreamUtils.copyToString(ctx.getResponseDataStream(), Charset.forName("UTF-8"));
            if (StringUtil.isNotEmpty(body)) {
                baseResult.setData(JsonUtil.json2java(body, Object.class));
            }
            ctx.setResponseBody(JsonUtil.java2json(baseResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
