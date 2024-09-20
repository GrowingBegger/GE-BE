package org.example.ge.global.exception;

import java.time.LocalDateTime;

public record ErrorResponse (
        Integer code,
        String message,
        String description,
        LocalDateTime timestamp
) {
    public static ErrorResponse of (ErrorCode errorCode, String description) {
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage(), description, LocalDateTime.now());
    }
}
