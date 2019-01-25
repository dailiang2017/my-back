package com.dail.advice;

import com.alibaba.fastjson.JSON;
import com.dail.dto.BaseResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Auther: dailiang
 * @Date: 2019/1/16 11:18
 * @Description: 统一包装返回值
 */
@Order(2)
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof BaseResult) {
            return o;
        } else if (o instanceof String) {
            return JSON.toJSONString(BaseResult.success(o));
        }
        BaseResult baseResult = new BaseResult();
        baseResult.setData(o);
        return baseResult;
    }
}
