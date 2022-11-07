package com.cyss.mycomputer.util;

import java.io.Serializable;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.util
 * @Author: cyss
 * @CreatTime: 2022-09-10 20:11
 * @Description:
 */
public class JsonResult<E> implements Serializable {
    private Integer state;
    private String message;
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
