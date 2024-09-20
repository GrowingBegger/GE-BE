package org.example.ge.global.exception;

import lombok.AllArgsConstructor;

public class BusinessException extends RuntimeException {
    public final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) { this.errorCode = errorCode; }
}
