package com.mathias.ui.vo;

import lombok.Data;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/6/1
 */
@Data
public class ResourceBean {
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
