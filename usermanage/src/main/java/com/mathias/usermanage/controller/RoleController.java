package com.mathias.usermanage.controller;

import com.mathias.usermanage.entity.RoleBean;
import com.mathias.usermanage.service.RoleService;
import com.mathias.usermanage.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/6
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/getRoleList")
    public ResponseHelper getRoleList(){
        return roleService.findRoleList();
    }

    @RequestMapping("/saveOrUpdate")
    public ResponseHelper saveOrUpdate(@RequestBody RoleBean roleBean){
        return roleService.saveOrUpdate(roleBean);
    }

    @RequestMapping("/roleInfo")
    public RoleBean getUserById(@RequestParam(name = "id") Long id){
        return roleService.findRoleById(id);
    }

    @RequestMapping("/delRoleById")
    public ResponseHelper delRoleById(@RequestParam(name ="ids" ) String ids){
        return roleService.delRoleById(ids);
    }
}
