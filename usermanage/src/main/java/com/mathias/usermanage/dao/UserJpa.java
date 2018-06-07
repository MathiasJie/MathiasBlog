package com.mathias.usermanage.dao;

import com.mathias.usermanage.entity.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
public interface UserJpa extends JpaRepository<UserBean,Long> {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    UserBean findByUsername(String username);

    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    UserBean findUserById(Long id);
}
