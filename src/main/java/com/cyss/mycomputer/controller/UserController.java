package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.controller.exception.*;
import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.service.IUserService;
import com.cyss.mycomputer.util.JsonResult;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller
 * @Author: cyss
 * @CreatTime: 2022-09-10 20:16
 * @Description:
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User data = userService.login(username, password);
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<Void> (OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){
        User result = userService.getByUid(getUidFromSession(session));
        return new JsonResult<User>(OK, result);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<Void>(OK);
    }

    //上传文件的最大值
    public static final Integer AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    //上传文件的类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        if(file.getSize() > AVATAR_MAX_SIZE){
            throw new FileSizeException("文件大小超出限制");
        }
        String contentType = file.getContentType();
        if(!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("文件类型错误");
        }
        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;
        File dest = new File(dir, filename);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        } catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = "/upload/" + filename;
        userService.changeAvatar(uid, avatar, username);
        return new JsonResult<String>(OK, avatar);
    }
}
