package com.mathias.usermanage.service.impl;

import com.google.common.collect.Maps;
import com.mathias.usermanage.dao.UserJpa;
import com.mathias.usermanage.entity.UserBean;
import com.mathias.usermanage.service.LoginService;
import com.mathias.usermanage.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserJpa userJpa;

    @Override
    public ResponseHelper signin(UserBean userBean, String ipAddress) {
        UserBean user = userJpa.findByUsername(userBean.getUsername());
        Map<String,Object> map =Maps.newHashMap();
        if (user != null){
            if (user.getPassword().equals(userBean.getPassword())){
                user.setLastLoginIp(ipAddress);
                user.setLastLoginTime(new Date());
                userJpa.save(user);
                map.put("user",user);
                return new ResponseHelper(200,"登陆成功",map);
            }
        }
        return new ResponseHelper(500,"用户名或者密码错误",null);
    }

    @Override
    public ResponseHelper logout() {
        return null;
    }
}
