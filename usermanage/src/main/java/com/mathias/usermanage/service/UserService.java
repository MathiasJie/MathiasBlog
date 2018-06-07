package com.mathias.usermanage.service;

import com.mathias.usermanage.entity.UserBean;
import com.mathias.usermanage.util.ResponseHelper;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/4
 */
public interface UserService {

    /**
     * 获取所有用户信息
     * @return ResponseHelper
     */
    ResponseHelper findUserList();

    /**
     * 添加或者修改用户
     * @return ResponseHelper
     */
    ResponseHelper saveOrUpdate(UserBean userBean,String ipAddress);

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     */
    UserBean findUserById(Long id);

    ResponseHelper delUserById(String ids);
}
