package org.example.ge.instrastructure.thirdparty.s3.exception;

import org.example.ge.instrastructure.exception.BusinessException;
import org.example.ge.instrastructure.exception.ErrorCode;

public class FileIOException extends BusinessException {
    public static final FileIOException EXCEPTION = new FileIOException();

    public FileIOException() { super(ErrorCode.FILE_IO_EXCEPTION); }
}
