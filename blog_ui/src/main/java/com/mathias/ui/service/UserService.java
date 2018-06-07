package com.mathias.ui.service;

import com.mathias.ui.util.ResponseHelper;
import com.mathias.ui.vo.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/4
 */
@FeignClient(value = "user-manage")
public interface UserService {
    /**
     * 获取所有用户信息
     * @return
     */
    @RequestMapping("/user/getUserList")
    ResponseHelper getUserList();

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/user/saveOrUpdate")
    ResponseHelper saveOrUpdate(@RequestBody UserBean userBean, @RequestParam(name = "ipAddress") String ipAddress);

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/user/userInfo")
    UserBean getUserById(@RequestParam(name = "id") Long id);

    @RequestMapping("/user/delUserById")
    ResponseHelper delUserById(@RequestParam(name = "ids")String ids);
}
