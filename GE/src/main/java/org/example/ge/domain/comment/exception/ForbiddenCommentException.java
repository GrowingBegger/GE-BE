package org.example.ge.domain.comment.exception;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class ForbiddenCommentException extends BusinessException {
    public static final ForbiddenCommentException EXCEPTION = new ForbiddenCommentException();

    public ForbiddenCommentException() { super(ErrorCode.FORBIDDEN_COMMENT); }
}
