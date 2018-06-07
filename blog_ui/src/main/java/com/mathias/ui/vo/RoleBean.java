package com.mathias.ui.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Data
public class RoleBean implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer available;
    private Date createTime;
    private Date updateTime;
    private List<ResourceBean> resources;
}
