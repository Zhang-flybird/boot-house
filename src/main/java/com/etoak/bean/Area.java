package com.etoak.bean;

import lombok.Data;

/**
 * 地区表对应的实体类
 */
@Data
public class Area {

    private Integer id;
    private Integer pid;
    private String name;
    private Integer sort;
}
