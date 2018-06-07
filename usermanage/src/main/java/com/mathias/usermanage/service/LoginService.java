package com.mathias.usermanage.service;

import com.mathias.usermanage.entity.UserBean;
import com.mathias.usermanage.util.ResponseHelper;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
public interface LoginService {
    /**
     * 登陆
     * @param userBean
     * @param ipAddress
     * @return ResponseHelper
     */
    ResponseHelper signin(UserBean userBean, String ipAddress);

    /**
     * 退出登录
     * @return
     */
    ResponseHelper logout();
}
