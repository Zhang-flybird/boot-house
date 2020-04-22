package com.etoak.mapper;

import com.etoak.bean.House;

public interface HouseMapper {
    /**
     * 添加房源信息
     * @param house
     * @return
     */
    int addHouse(House house);
}
