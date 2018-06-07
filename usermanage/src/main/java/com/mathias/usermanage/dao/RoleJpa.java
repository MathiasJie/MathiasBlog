package com.mathias.usermanage.dao;

import com.mathias.usermanage.entity.RoleBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
public interface RoleJpa extends JpaRepository<RoleBean,Long> {

    /**
     * 通过Id查找角色
     * @param id
     * @return
     */
    RoleBean findRoleBeanById(Long id);

    /**
     * 通过角色名查找角色
     * @param name
     * @return
     */
    RoleBean findByName(String name);
}
