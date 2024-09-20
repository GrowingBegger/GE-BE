package org.example.ge.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(400, "잘못된 요청"),
    INTERNAL_SERVER_ERROR(500, "서버 오류");

    private final Integer code;
    private final String message;
}
