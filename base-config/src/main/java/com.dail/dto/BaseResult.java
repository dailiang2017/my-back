package com.dail.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: dailiang
 * @Date: 2018/12/25 14:55
 * @Description: 相应result类型
 */
@Data
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean success = true;
    private String msg;
    private Object data;

    public static BaseResult success() {
        BaseResult result = new BaseResult();
        return result;
    }

    public static BaseResult success(String msg) {
        BaseResult result = new BaseResult();
        result.setMsg(msg);
        return result;
    }

    public static BaseResult success(Object data) {
        BaseResult result = new BaseResult();
        result.setData(data);
        return result;
    }

    public static BaseResult error() {
        BaseResult result = new BaseResult();
        result.setSuccess(false);
        return result;
    }

    public static BaseResult error(String msg) {
        BaseResult result = new BaseResult();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }
}
