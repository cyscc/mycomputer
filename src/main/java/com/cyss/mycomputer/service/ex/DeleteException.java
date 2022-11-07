package com.cyss.mycomputer.service.ex;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.ex
 * @Author: cyss
 * @CreatTime: 2022-09-14 16:08
 * @Description:
 */
public class DeleteException extends ServiceException{
    public DeleteException() {
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
