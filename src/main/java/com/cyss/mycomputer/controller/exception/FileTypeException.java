package com.cyss.mycomputer.controller.exception;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller.exception
 * @Author: cyss
 * @CreatTime: 2022-09-12 09:29
 * @Description:
 */
public class FileTypeException extends FileUploadException {
    public FileTypeException() {
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
