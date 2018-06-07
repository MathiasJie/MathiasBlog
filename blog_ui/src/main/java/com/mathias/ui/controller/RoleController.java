package com.mathias.ui.controller;

import com.mathias.ui.service.RoleService;
import com.mathias.ui.util.ResponseHelper;
import com.mathias.ui.vo.RoleBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/4
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequestMapping("/getRoleList")
    public ResponseHelper getUserList(){
        return roleService.getRoleList();
    }

    @RequestMapping("/saveOrUpdate")
    public ResponseHelper saveOrUpdate(RoleBean roleBean){
        return roleService.saveOrUpdate(roleBean);
    }
    @RequestMapping("/roleInfo")
    public ModelAndView roleInfo(Long id){
        ModelAndView mv = new ModelAndView();
        RoleBean roleBean = roleService.getRoleById(id);
        mv.addObject("roleInfo",roleBean);
        mv.setViewName("role/editRole");
        return mv;
    }

    @RequestMapping("/delRoleById")
    public ResponseHelper delRoleById(String ids){
        return roleService.delRoleById(ids);
    }




}
