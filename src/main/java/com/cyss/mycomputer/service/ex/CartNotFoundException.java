package com.cyss.mycomputer.service.ex;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.ex
 * @Author: cyss
 * @CreatTime: 2022-11-10 20:15
 * @Description:
 */
public class CartNotFoundException extends ServiceException{
    public CartNotFoundException() {
        super();
    }

    public CartNotFoundException(String message) {
        super(message);
    }

    public CartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CartNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
