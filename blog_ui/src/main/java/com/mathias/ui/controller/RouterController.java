package com.mathias.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/5/29
 */
@Controller
@RequestMapping("/route")
public class RouterController {


    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/userManage")
    public String userManage(){
        return "user/userManage";
    }
    @RequestMapping("/addUser")
    public String addUser(){
        return "user/addUser";
    }

    @RequestMapping("/roleManage")
    public String roleManage(){
        return "role/roleManage";
    }

    @RequestMapping("/addRole")
    public String addRole(){
        return "role/addRole";
    }

}
