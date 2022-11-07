package com.cyss.mycomputer.service.ex;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.ex
 * @Author: cyss
 * @CreatTime: 2022-09-11 15:34
 * @Description:
 */
public class UpdateException extends ServiceException{
    public UpdateException() {
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
