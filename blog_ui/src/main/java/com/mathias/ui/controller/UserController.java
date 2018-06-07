package com.mathias.ui.controller;

import com.mathias.ui.service.UserService;
import com.mathias.ui.util.CusAccessObjectUtil;
import com.mathias.ui.util.ResponseHelper;
import com.mathias.ui.vo.UserBean;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        return userService.getUserList();
    }

    @RequestMapping("/saveOrUpdate")
    public ResponseHelper saveOrUpdate(UserBean userBean, HttpServletRequest request){
        String ipAddress = CusAccessObjectUtil.getIpAddress(request);
        return userService.saveOrUpdate(userBean, ipAddress);
    }
    @RequestMapping("/userInfo")
    public ModelAndView userInfo(Long id){
        ModelAndView mv = new ModelAndView();
        UserBean userBean = userService.getUserById(id);
        mv.addObject("userInfo",userBean);
        mv.setViewName("user/userInfo");
        return mv;
    }

    @RequestMapping("/delUserById")
    public ResponseHelper delUserById(String ids){
        return userService.delUserById(ids);
    }












//    ---------------------------------------非控制器部分--------------------------------------------
    /**
     * 处理form表单的时间
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
    }
}
