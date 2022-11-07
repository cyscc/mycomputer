package com.cyss.mycomputer.service.ex;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.ex
 * @Author: cyss
 * @CreatTime: 2022-11-01 20:32
 * @Description:
 */
public class ProductNotFoundException extends ServiceException{
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
