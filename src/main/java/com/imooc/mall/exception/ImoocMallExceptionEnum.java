package com.imooc.mall.exception;

public enum ImoocMallExceptionEnum {
    NEED_USER_NAME( 10001,"用户名不能为空"),
    NEED_USER_PASSWORD(10002,"密码不能为空"),
    PASSWORD_LENGTH_TO_SORT(10003,"密码最短需要8位"),
    NAME_EXISTED(10004,"用户名重复"),
    INSERT_FAILED(10005,"插入失败,请重试"),
    SYSTEM_ERROR(20000,"系统异常");
    /**
     * 异常码
     */
    Integer code;
    String msg;

    ImoocMallExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ImoocMallExceptionEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
