package com.cyss.mycomputer.controller.exception;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller.exception
 * @Author: cyss
 * @CreatTime: 2022-09-12 09:27
 * @Description:
 */
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
