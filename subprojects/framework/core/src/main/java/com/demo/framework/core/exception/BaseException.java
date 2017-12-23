/**
 * 
 */
package com.demo.framework.core.exception;

/**
 * 异常基类
 * 
 * @author 袁进勇
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 异常错误码
     */
    protected String code;

    /**
     * 异常信息的参数
     */
    protected Object[] args;

    /**
     *
     */
    public BaseException() {
        super();
    }

    /**
     *
     * @param message
     *            错误信息
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     *            错误信息
     * @param cause
     *            原始异常
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param code
     *            错误码
     * @param message
     *            错误信息
     */
    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
     *
     * @param code
     *            错误码
     * @param message
     *            错误信息
     * @param cause
     *            原始异常
     */
    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     *
     * @param message
     *            错误信息
     * @param args
     *            额外参数
     */
    public BaseException(String message, Object... args) {
        super(message);
        this.args = args;
    }

    /**
     *
     * @param message
     *            错误信息
     * @param cause
     *            原始异常
     * @param args
     *            额外参数
     */
    public BaseException(String message, Throwable cause, Object... args) {
        super(message, cause);
        this.args = args;
    }

    /**
     *
     * @param code
     *            错误码
     * @param message
     *            错误信息
     * @param args
     *            额外参数
     */
    public BaseException(String code, String message, Object... args) {
        super(message);
        this.code = code;
        this.args = args;
    }

    /**
     *
     * @param code
     *            错误码
     * @param message
     *            错误信息
     * @param cause
     *            原始异常
     * @param args
     *            额外参数
     */
    public BaseException(String code, String message, Throwable cause, Object... args) {
        super(message, cause);
        this.code = code;
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        if (args == null || args.length == 0) {
            return super.getMessage();
        }

        String message = super.getMessage();
        if (message != null && message.trim().length() > 0) {
            message = String.format(message, args);
        }
        return message;
    }

    public Object[] getArgs() {
        return args;
    }
}
