/**
 * 
 */
package com.demo.framework.core.exception;

/**
 * 业务异常
 * 
 * @author 袁进勇
 *
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 7325689908042779385L;

    /**
     *
     */
    public BusinessException() {
        super();
    }

    /**
     *
     * @param message
     *            错误信息
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     *            错误信息
     * @param cause
     *            原始异常
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param code
     *            错误码
     * @param message
     *            错误信息
     */
    public BusinessException(String code, String message) {
        super(code, message);
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
    public BusinessException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    /**
     *
     * @param message
     *            错误信息
     * @param args
     *            额外参数
     */
    public BusinessException(String message, Object... args) {
        super(message, args);
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
    public BusinessException(String message, Throwable cause, Object... args) {
        super(message, cause, args);
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
    public BusinessException(String code, String message, Object... args) {
        super(code, message, args);
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
    public BusinessException(String code, String message, Throwable cause, Object... args) {
        super(code, message, cause, args);
    }
}
