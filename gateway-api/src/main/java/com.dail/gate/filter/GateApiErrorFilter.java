package com.dail.gate.filter;

import com.dail.dto.BaseResult;
import com.dail.exception.BusinessException;
import com.dail.utils.JsonUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Auther: dailiang
 * @Date: 2019/1/15 11:58
 * @Description:
 */
@Slf4j
@Component
public class GateApiErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        BaseResult baseResult = new BaseResult();
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getThrowable() != null && ctx.getThrowable().getCause() != null) {
            baseResult.setSuccess(false);
            if( ctx.getThrowable().getCause() instanceof BusinessException){
                BusinessException bex = (BusinessException)ctx.getThrowable().getCause();
                baseResult.setMsg(bex.getMessage());
                log.error("BusinessException　业务验证异常...... errorCode= "+ bex.getCode() +"  message= "+bex.getMessage() );
            } else {
                baseResult.setMsg(ctx.getThrowable().getCause().getMessage());
                log.error("其它异常...... " );
            }
            ctx.getResponse().setHeader("content-type", "application/json;charset=utf-8");
            ctx.setResponseBody(JsonUtil.java2json(baseResult));
        }
        return null;
    }
}
