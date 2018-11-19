package com.chenhaibo.exception;

/**
 * @Author: com.com.chenhaibo
 * @Description:
 * @Date: Created in 14:45 2018/8/15
 */
public enum MyExceptionEnums {

    REQUEST_EMPTY(2001, "请求参数为空");

    private Integer code;
    private String msg;

    MyExceptionEnums(Integer code, String msg) {
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
}
