package com.mathias.usermanage.service;

import com.mathias.usermanage.entity.RoleBean;
import com.mathias.usermanage.util.ResponseHelper;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/6
 */
public interface RoleService {

    /**
     * 获取所有角色信息
     * @return ResponseHelper
     */
    ResponseHelper findRoleList();

    /**
     * 保存或者修改角色
     * @param roleBean
     * @return ResponseHelper
     */
    ResponseHelper saveOrUpdate(RoleBean roleBean);

    /**
     * 根据ID查询角色
     * @param id
     * @return
     */
    RoleBean findRoleById(Long id);

    /**
     * 根据ID删除角色
     * @param ids
     * @return
     */
    ResponseHelper delRoleById(String ids);
}
