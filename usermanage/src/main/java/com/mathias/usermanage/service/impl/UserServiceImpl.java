package com.mathias.usermanage.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mathias.usermanage.dao.RoleJpa;
import com.mathias.usermanage.dao.UserJpa;
import com.mathias.usermanage.entity.RoleBean;
import com.mathias.usermanage.entity.UserBean;
import com.mathias.usermanage.service.UserService;
import com.mathias.usermanage.util.ResponseHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/4
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserJpa userJpa;
    @Resource
    private RoleJpa roleJpa;

    @Override
    public ResponseHelper findUserList() {
        List<UserBean> userList = userJpa.findAll();
        Map<String, Object> map = Maps.newHashMap();
        map.put("userList", userList);
        return new ResponseHelper(200, "请求成功", map);
    }

    @Override
    public ResponseHelper saveOrUpdate(UserBean userBean, String ipAddress) {

        try {
            //        如果ID为空,新增
            if (userBean.getId() == null) {
                UserBean user = userJpa.findByUsername(userBean.getUsername());
                if (user != null){
                    return new ResponseHelper(500, "用户名已存在", null);
                }
//                默认的用户状态
                userBean.setStatus(1);
                userBean.setRegisterIp(ipAddress);
                userBean.setCreateTime(new Date());
                List<RoleBean> roleList = Lists.newArrayList();
//            TODO 默认附一个管理员角色，后续会更改
                RoleBean role = roleJpa.findRoleBeanById(7L);
                roleList.add(role);
                userBean.setRoleList(roleList);
                userJpa.save(userBean);
            } else {
//            修改
                UserBean u = userJpa.findUserById(userBean.getId());
                u.setBirthday(userBean.getBirthday());
                u.setGender(userBean.getGender());
                u.setNickName(userBean.getNickName());
                u.setMobile(userBean.getMobile());
                u.setQq(userBean.getQq());
                u.setEmail(userBean.getEmail());
                u.setUpdateTime(new Date());
                if (userBean.getStatus() == null){
                    u.setStatus(0);
                }else{
                    u.setStatus(userBean.getStatus());
                }
                userJpa.save(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseHelper(500, "保存失败", null);
        }
        return new ResponseHelper(200, "保存成功", null);
    }

    @Override
    public UserBean findUserById(Long id) {
        return userJpa.findUserById(id);
    }

    @Override
    public ResponseHelper delUserById(String ids) {
        String[] userIds = ids.split(",");
        for (String id: userIds) {
            try {
                UserBean user = userJpa.findUserById(Long.valueOf(id));
                user.setStatus(0);
                user.setUpdateTime(new Date());
                userJpa.save(user);
            }catch (Exception e){
                e.printStackTrace();
                Map<String,Object> map = Maps.newHashMap();
                map.put("msg",e.getMessage());
                return new ResponseHelper(200, "删除失败", map);
            }

        }
        return new ResponseHelper(200, "删除成功", null);
    }
}
