package com.dail.exception;

import com.dail.enums.ErrorCodeEnum;

/**
 * @Auther: dailiang
 * @Date: 2019/1/14 18:13
 * @Description: 业务异常
 */
public class BusinessException extends BaseException {

    public BusinessException(String message){
        this.code = ErrorCodeEnum.BUSSINESS_EXCEPTION.getCode();
        this.message =message;
    }
    public BusinessException(String code, String message){
        this.code = code;
        this.message = message;
    }
    public BusinessException(ErrorCodeEnum errorCodeEnum){
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getRemark();
    }
}
