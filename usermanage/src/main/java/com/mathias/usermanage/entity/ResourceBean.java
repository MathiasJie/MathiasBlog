package com.mathias.usermanage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Entity
@Data
@Table(name = "resources")
public class ResourceBean {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String url;
    private String permission;
    private Integer sort;
    private Integer available;
    private String icon;
    private String createTime;
    private String updateTime;
}
