package com.chenhaibo.exception;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 14:44 2018/8/15
 */
public class MyException extends RuntimeException {
    private Integer code;
    private String msg;
    private Exception exception;

    public MyException(MyExceptionEnums enums) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
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

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
