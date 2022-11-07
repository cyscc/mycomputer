package com.cyss.mycomputer.service.ex;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.ex
 * @Author: cyss
 * @CreatTime: 2022-09-10 19:39
 * @Description: 在数据插入的过程中产生了异常，数据库宕机...
 */
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
