package com.mathias.ui.controller;

import com.mathias.ui.service.LoginService;
import com.mathias.ui.util.CusAccessObjectUtil;
import com.mathias.ui.util.ResponseHelper;
import com.mathias.ui.vo.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：mathias
 * Description:登陆控制器11
 * Date: 2018/6/1
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping("/signin")
    public ResponseHelper signin(UserBean userBean, HttpServletRequest request){
        String ipAddress = CusAccessObjectUtil.getIpAddress(request);
        return loginService.signin(userBean,ipAddress);
    }

   
}
