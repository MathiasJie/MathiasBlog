package com.mathias.ui.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Data
public class UserBean {
    private Long id;
    private String username;
    private String password;
    private String nickName;
    private String mobile;
    private String email;
    private String qq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer gender;
    private Integer status;
    private String avatar;
    private String registerIp;
    private String lastLoginIp;
    private Date lastLoginTime;
    private Date createTime;
    private Date updateTime;
    private List<RoleBean> roleList;

}
