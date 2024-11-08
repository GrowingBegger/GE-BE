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
    INTERNAL_SERVER_ERROR(500, "서버 오류"),

    // post
    InvalidAuthorDeletionException(400, "작성자만 삭제할 수 있습니다."),
    POST_NOT_FOUND(404, "존재하지 않는 게시글입니다."),

    // comment
    FORBIDDEN_COMMENT(403, "자신이 작성하지 않은 댓글의 수정 또는 삭제를 시도했습니다."),
    COMMENT_NOT_FOUND(404, "존재하지 않는 댓글입니다"),

    // like
    NOT_VALID_LIKE_TYPE(400, "존재하지 않는 좋아요 타입입니다.")
      
    // rating
    RATING_NOT_FOUND(404, "존재하지 않는 평가입니다.")
    ;

    private final Integer code;
    private final String message;
}
