package com.etoak.mapper;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;

import java.util.List;

public interface HouseMapper {
    /**
     * 添加房源信息
     * @param house
     * @return
     */
    int addHouse(House house);

    /**
     * 列表查询
     * @param houseVo
     * @return
     */
    List<HouseVo> queryList(HouseVo houseVo);

}
