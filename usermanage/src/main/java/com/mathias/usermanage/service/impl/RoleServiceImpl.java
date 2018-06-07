package com.mathias.usermanage.service.impl;

import com.google.common.collect.Maps;
import com.mathias.usermanage.dao.RoleJpa;
import com.mathias.usermanage.entity.RoleBean;
import com.mathias.usermanage.service.RoleService;
import com.mathias.usermanage.util.ResponseHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/6
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleJpa roleJpa;

    @Override
    public ResponseHelper findRoleList() {
        List<RoleBean> roles = roleJpa.findAll();
        Map<String,Object> map = Maps.newHashMap();
        map.put("roleList",roles);
        return new ResponseHelper(200,"请求成功",map);
    }

    @Override
    public ResponseHelper saveOrUpdate(RoleBean roleBean) {
        try {
            //        如果ID为空,新增
            if (roleBean.getId() == null) {
                RoleBean role = roleJpa.findByName(roleBean.getName());
                if (role != null){
                    return new ResponseHelper(500, "角色名已存在", null);
                }
//                默认的用户状态
                roleBean.setAvailable(roleBean.getAvailable());
                roleBean.setDescription(roleBean.getDescription());
                roleBean.setCreateTime(new Date());
                roleJpa.save(roleBean);
            } else {
//                修改
                RoleBean r = roleJpa.findRoleBeanById(roleBean.getId());
                r.setDescription(roleBean.getDescription());
                r.setUpdateTime(new Date());
                if (roleBean.getAvailable() == null){
                    r.setAvailable(0);
                }
                r.setAvailable(roleBean.getAvailable());
                roleJpa.save(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseHelper(500, "保存失败", null);
        }
        return new ResponseHelper(200, "保存成功", null);
    }

    @Override
    public RoleBean findRoleById(Long id) {
        return roleJpa.findRoleBeanById(id);
    }

    @Override
    public ResponseHelper delRoleById(String ids) {
        String[] roleIds = ids.split(",");
        for (String id : roleIds) {
            try{
                RoleBean role = roleJpa.findRoleBeanById(Long.valueOf(id));
                role.setAvailable(0);
                role.setUpdateTime(new Date());
                roleJpa.save(role);
            }catch (Exception e){
                e.printStackTrace();
                Map<String,Object> map =Maps.newHashMap();
                map.put("msg",e.getMessage());
                return new ResponseHelper(200, "删除失败", map);
            }

        }
        return new ResponseHelper(200, "删除成功", null);
    }
}
