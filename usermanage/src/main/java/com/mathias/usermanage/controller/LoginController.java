package com.mathias.usermanage.controller;

import com.mathias.usermanage.entity.UserBean;
import com.mathias.usermanage.service.LoginService;
import com.mathias.usermanage.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/signin")
    public ResponseHelper signin(@RequestBody UserBean userBean, @RequestParam(name = "ipAddress") String ipAddress){
      return loginService.signin(userBean,ipAddress);
  }
}
