package com.dail.enums;

/**
 *
 *  错误码五位，1位字母+4位数字
 *  以  1-5 开头的错误信息与HttpStatus一致
 *  以  6 开头的警告信息(提交非法数据、)
 *  以  7 开头的提示信息(业务异常等)
 * @Auther: dailiang
 * @Date: 2019/1/14 18:19
 * @Description: 认证字段枚举
 */
public enum ErrorCodeEnum {

    SUCCESS(200,"成功"),
    UNAUTHORIZED(401,"该用户没有该权限"),
    REPEAT_LOGIN(600,"该账户已在其它设备登录，请先退出。如果此登录非您本人操作，请联系客服申诉。"),
    LOGIN_EXPIRE(601,"登录过期，请重新登录"),
    BUSSINESS_EXCEPTION(700,"业务异常"),
    ;

    private int code;
    private String remark;
    private ErrorCodeEnum(int code, String remark) {
        this.code = code;
        this.remark = remark;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
