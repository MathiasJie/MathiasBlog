package com.mathias.usermanage.controller;

import com.mathias.usermanage.entity.UserBean;
import com.mathias.usermanage.service.UserService;
import com.mathias.usermanage.util.ResponseHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/4
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/getUserList")
    public ResponseHelper getUserList(){
        return userService.findUserList();
    }

    @RequestMapping("/saveOrUpdate")
    public ResponseHelper saveOrUpdate(@RequestBody  UserBean userBean, @RequestParam(name = "ipAddress") String ipAddress){
        return userService.saveOrUpdate(userBean,ipAddress);
    }

    @RequestMapping("/userInfo")
    public UserBean getUserById(@RequestParam(name = "id") Long id){
        return userService.findUserById(id);
    }

    @RequestMapping("/delUserById")
    public ResponseHelper delUserById(@RequestParam(name ="ids" ) String ids){
        return userService.delUserById(ids);
    }

}
