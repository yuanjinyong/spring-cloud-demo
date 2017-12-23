package com.demo.framework.core.model;

public class Result<T> {
    private static final String SUCCESS_CODE = "0";
    private static final String SUCCESS_MESSAGE = "处理成功。";

    private String code; // 结果码
    private String message; // 结果描述
    private T data; // 结果数据

    public Result() {
        this("0", SUCCESS_MESSAGE, null);
    }

    public Result(T data) {
        this("0", SUCCESS_MESSAGE, data);
    }

    public Result(String message) {
        this("-1", message, null);
    }

    public Result(String code, String message) {
        this(code, message, null);
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return SUCCESS_CODE.equals(this.code);
    }
}
