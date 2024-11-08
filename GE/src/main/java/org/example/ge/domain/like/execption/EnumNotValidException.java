package org.example.ge.domain.like.execption;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class EnumNotValidException extends BusinessException {
    public static final EnumNotValidException EXCEPTION = new EnumNotValidException();

    public EnumNotValidException() { super(ErrorCode.NOT_VALID_LIKE_TYPE); }
}
