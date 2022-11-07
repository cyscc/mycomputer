package com.cyss.mycomputer.controller.exception;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller.exception
 * @Author: cyss
 * @CreatTime: 2022-09-12 09:30
 * @Description:
 */
public class FileUploadIOException extends FileUploadException {
    public FileUploadIOException() {
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    public FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
