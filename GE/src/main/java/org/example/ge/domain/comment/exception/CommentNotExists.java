package org.example.ge.domain.comment.exception;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class CommentNotExists extends BusinessException {
    public static final CommentNotExists EXCEPTION = new CommentNotExists();

    public CommentNotExists() { super(ErrorCode.COMMENT_NOT_FOUND); }
}
