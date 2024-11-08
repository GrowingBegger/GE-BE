package org.example.ge.domain.rating.exception;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class RatingNotFoundException extends BusinessException {
    public static final RatingNotFoundException EXCEPTION = new RatingNotFoundException();

    private RatingNotFoundException() {
        super(ErrorCode.RATING_NOT_FOUND);
    }
}
