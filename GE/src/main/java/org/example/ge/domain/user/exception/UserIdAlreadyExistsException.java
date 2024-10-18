package org.example.ge.domain.user.exception;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class UserIdAlreadyExistsException extends BusinessException {
    public static final UserIdAlreadyExistsException EXCEPTION = new UserIdAlreadyExistsException();

    public UserIdAlreadyExistsException() { super(ErrorCode.USER_ID_ALREADY_EXISTS); }
}
