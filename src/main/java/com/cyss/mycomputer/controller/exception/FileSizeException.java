package com.cyss.mycomputer.controller.exception;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller.exception
 * @Author: cyss
 * @CreatTime: 2022-09-12 09:29
 * @Description:
 */
public class FileSizeException extends FileUploadException {
    public FileSizeException() {
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
