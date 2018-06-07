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
 * Date: 2018/6/1
 */
@FeignClient(value ="user-manage" )
public interface LoginService {
    /**
     * 登陆
     * @param userBean
     * @param ipAddress
     * @return
     */
    @RequestMapping("/login/signin")
    ResponseHelper signin(@RequestBody UserBean userBean,@RequestParam(name = "ipAddress") String ipAddress);
}
