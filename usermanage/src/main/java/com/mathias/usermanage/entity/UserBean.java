package com.mathias.usermanage.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Entity
@Data
@Table(name = "user")
public class UserBean {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String username;
    private String password;
    @Column(name = "nickName")
    private String nickName;
    private String mobile;
    @Email
    private String email;
    private String qq;
    private Date birthday;
    private Integer gender;
    private Integer status;
    private String avatar;
    @Column(name = "registerIp")
    private String registerIp;
    @Column(name = "lastLoginIp")
    private String lastLoginIp;
    @Column(name = "lastLoginTime")
    private Date lastLoginTime;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "updateTime")
    private Date updateTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "userId")}
            ,inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<RoleBean> roleList;

}
