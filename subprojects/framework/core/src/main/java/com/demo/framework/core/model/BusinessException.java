/**
 * 
 */
package com.demo.framework.core.model;

/**
 * @author 袁进勇
 *
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 7325689908042779385L;
    private Long code; // 异常编码
    private String message; // 异常信息
    private Object[] args;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(Object... args) {
        super();
        this.args = args;
    }

    public BusinessException(String message, Object... args) {
        super(message);
        this.message = message;
        this.args = args;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public BusinessException(Throwable cause, Object... args) {
        super(cause);
        this.args = args;
    }

    public BusinessException(String message, Throwable cause, Object... args) {
        super(message, cause);
        this.message = message;
        this.args = args;
    }

    public BusinessException(Long code) {
        super();
        this.code = code;
    }

    public BusinessException(Long code, String message) {
        this(message);
        this.code = code;
    }

    public BusinessException(Long code, Object... args) {
        this(args);
        this.code = code;
    }

    public BusinessException(Long code, String message, Object... args) {
        this(message, args);
        this.code = code;
    }

    public BusinessException(Long code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BusinessException(Long code, String message, Throwable cause) {
        this(message, cause);
        this.code = code;
    }

    public BusinessException(Long code, Throwable cause, Object... args) {
        this(args, cause);
        this.code = code;
    }

    public BusinessException(Long code, String message, Throwable cause, Object... args) {
        this(code, message, cause);
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object... args) {
        this.args = args;
    }

    public String getFormattedMessage() {
        if (args == null || args.length == 0 || message == null || message.trim().length() == 0) {
            return message;
        }

        return String.format(message, args);
    }
}
