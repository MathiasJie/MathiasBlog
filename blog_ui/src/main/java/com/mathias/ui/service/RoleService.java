package com.mathias.ui.service;

import com.mathias.ui.util.ResponseHelper;
import com.mathias.ui.vo.RoleBean;
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
public interface RoleService {
    /**
     * 获取所有角色信息
     * @return
     */
    @RequestMapping("/role/getRoleList")
    ResponseHelper getRoleList();

    /**
     * 添加角色
     * @return
     */
    @RequestMapping("/role/saveOrUpdate")
    ResponseHelper saveOrUpdate(@RequestBody RoleBean roleBean);

    /**
     * 根据角色ID获取角色信息
     * @param id
     * @return
     */
    @RequestMapping("/role/roleInfo")
    RoleBean getRoleById(@RequestParam(name = "id") Long id);

    /**
     * 根据ID删除角色
     * @param ids
     * @return
     */
    @RequestMapping("/role/delRoleById")
    ResponseHelper delRoleById(@RequestParam(name = "ids") String ids);
}
