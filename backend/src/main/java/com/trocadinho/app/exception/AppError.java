package com.trocadinho.app.exception;

public enum AppError {
    RESOURCE_NOT_FOUND("TRQ-GEN404", "The requested resource was not found.", 404),
    VALIDATION_FAILED("TRQ-GEN400", "Invalid or incomplete input data.", 400),
    DUPLICATE_RESOURCE("TRQ-GEN409", "A resource with the specified identifier already exists.", 409),
    RESOURCE_IN_USE("TRQ-GEN409", "The resource is currently in use and cannot be modified or deleted", 409);

    private final String code;
    private final String message;
    private final int httpStatus;

    AppError(String code, String message, int httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus =httpStatus;
    }

    public String getCode() { return code; }
    public String getMessage() { return message; }
    public int getHttpStatus() { return httpStatus; }
}
