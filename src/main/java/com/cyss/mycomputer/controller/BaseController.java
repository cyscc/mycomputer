package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.controller.exception.*;
import com.cyss.mycomputer.service.ex.*;
import com.cyss.mycomputer.util.JsonResult;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller
 * @Author: cyss
 * @CreatTime: 2022-09-10 20:27
 * @Description:
 */
public class BaseController {
    public static final int OK = 200;

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已被注册");
        }else if(e instanceof UsernameNotFoundException){
            result.setState(4001);
            result.setMessage("用户名不存在");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("密码错误");
        }else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("用户收货地址超出最大值");
        }else if (e instanceof AccessDeniedException) {
            result.setState(4004);
            result.setMessage("收获地址数据非法访问异常");
        }else if (e instanceof AddressNotFoundException) {
            result.setState(4005);
            result.setMessage("收货地址不存在的异常");
        }else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("商品数据不存在的异常");
        }else if (e instanceof CartNotFoundException) {
            result.setState(4007);
            result.setMessage("购物车数据不存在的异常");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        }else if(e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新数据时产生异常");
        }else if(e instanceof DeleteException){
            result.setState(5002);
            result.setMessage("删除数据时产生异常");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }


    public final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
