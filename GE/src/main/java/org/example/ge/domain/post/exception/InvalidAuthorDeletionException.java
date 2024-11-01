package org.example.ge.domain.post.exception;

import org.example.ge.domain.user.exception.PasswordMismatches;
import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class InvalidAuthorDeletionException extends BusinessException {

    public static final InvalidAuthorDeletionException EXCEPTION = new InvalidAuthorDeletionException();

    public InvalidAuthorDeletionException() { super(ErrorCode.InvalidAuthorDeletionException); }
}
