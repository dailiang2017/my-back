package com.dail.advice;

import com.dail.dto.BaseResult;
import com.dail.exception.BusinessException;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: dailiang
 * @Date: 2019/1/16 11:20
 * @Description:
 */
@Order(1)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public BaseResult exceptionHandle(HttpServletRequest request, Exception ex, HttpServletResponse response) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(false);
        baseResult.setMsg(ex.getMessage());
        return baseResult;
    }
}
