package org.example.ge.domain.user.exception;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class PasswordMismatches extends BusinessException {

    public static final PasswordMismatches EXCEPTION = new PasswordMismatches();

    public PasswordMismatches() { super(ErrorCode.PASSWORD_MISMATCHES); }
}
