package com.trocadinho.app.exception;


public class AppException extends RuntimeException {
    private final AppError errorType;

    public AppException(AppError errorType, String detail, Throwable cause) {
        super(errorType.getMessage(), cause);
        this.errorType = errorType;
    }

    public AppException(AppError errorType, String detail) {
        super(detail);
        this.errorType = errorType;
    }

    public AppError getErrorType() {
        return errorType;
    }
}
