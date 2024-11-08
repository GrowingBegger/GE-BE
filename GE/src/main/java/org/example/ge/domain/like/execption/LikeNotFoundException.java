package org.example.ge.domain.like.execption;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class LikeNotFoundException extends BusinessException {
    public static final LikeNotFoundException EXCEPTION = new LikeNotFoundException();

    public LikeNotFoundException() { super(ErrorCode.LIKE_NOT_EXIST); }
}
