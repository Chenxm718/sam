package com.sam.annotation.exception;

/**
 * Created by ChenXinmin on 2017/9/27.
 * 自定义运行时异常
 */
public class AException extends RuntimeException {
    /**
     * 异常编码
     */
    private String errorCode;
    /**
     * 异常消息
     */
    private String errorMessage;

    public AException(String errorMessage){
        super(errorMessage);
    }

    public AException(String errorCode,Throwable throwable){
        super(errorCode,throwable);
    }
    public AException(Throwable throwable){
        super(throwable);
    }
    public AException(String errorCode,String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
