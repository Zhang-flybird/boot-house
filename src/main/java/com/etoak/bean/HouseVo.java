package com.etoak.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HouseVo extends House {

    private String rentModeName;
    private String houseTypeName;
    private String orientationName;
    /**
     * 这里使用list和数组两种方式
     */
    //接收前端的户型参数
    @JsonIgnore//不把这个字段封装到返回结果json中
    private String[] houseTypeList;
    //接受前端的朝向参数
    @JsonIgnore
    private List<String> orientationList;

    //100-1000,1000-1500
    //这个不是用来接受参数  而是传入mybatis的参数
    List<Map<String,Integer>> rentalMapList;


}
