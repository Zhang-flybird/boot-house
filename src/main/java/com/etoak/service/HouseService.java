package com.etoak.service;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;

public interface HouseService {

    int addHouse(House house);

    Page<HouseVo> queryList(int pageNum,int pageSize,HouseVo houseVo,String[] rentalList);

    /**
     * 更新房源
     * @param house
     * @return
     */
    int updateHouse(House house);
}
