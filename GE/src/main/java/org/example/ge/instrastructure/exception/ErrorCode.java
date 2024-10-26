package org.example.ge.instrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // user
    PASSWORD_MISMATCHES(401, "비밀번호가 맞지 않습니다"),
    USER_NOT_EXISTS(404, "존재하지 않는 유저로 로그인을 시도했습니다."),
    USER_ID_ALREADY_EXISTS(409, "이미 존재하는 유저 아이디입니다."),

    // S3
    FILE_IO_EXCEPTION(500, "파일 업로드 중 문제가 생겼습니다."),

    BAD_REQUEST(400, "잘못된 요청"),
    INTERNAL_SERVER_ERROR(500, "서버 오류");

    private final Integer code;
    private final String message;
}
