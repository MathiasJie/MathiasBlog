package com.mathias.usermanage.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Entity
@Data
@Table(name = "role")
public class RoleBean implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Integer available;
    private Date createTime;
    private Date updateTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_resource",joinColumns ={@JoinColumn(name = "roleId")}
            ,inverseJoinColumns = {@JoinColumn(name = "resourceId")})
    private List<ResourceBean> resources;
}
