package com.cyss.mycomputer.controller.exception;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller.exception
 * @Author: cyss
 * @CreatTime: 2022-09-12 09:28
 * @Description:
 */
public class FileEmptyException extends FileUploadException {
    public FileEmptyException() {
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
