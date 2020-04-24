package com.etoak.service.impl;

import com.etoak.bean.Area;
import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;
import com.etoak.mapper.AreaMapper;
import com.etoak.mapper.HouseMapper;
import com.etoak.service.HouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    AreaMapper areaMapper;

    @Override
    public int addHouse(House house) {
        //给house设置地区所在名称areaName
        Area area = areaMapper.queryById(house.getArea());
        if(area == null){
            log.error("未查询到所在区，查询所在区ID -{}",house.getArea());
            throw new RuntimeException("服务端异常");
        }
        house.setAreaName(area.getName());
        return houseMapper.addHouse(house);
    }

    @Override
    public Page<HouseVo> queryList(int pageNum, int pageSize, HouseVo houseVo,String[] rentalList) {
        this.handleRental(houseVo,rentalList);
        PageHelper.startPage(pageNum,pageSize);
        List<HouseVo> houseVoList = houseMapper.queryList(houseVo);
        PageInfo<HouseVo> pageInfo = new PageInfo<>(houseVoList);
        return new Page<HouseVo>(pageInfo.getPageNum(),
                    pageInfo.getPageSize(),
                    houseVoList,
                    pageInfo.getTotal(),
                    pageInfo.getPages());
    }

    private void handleRental(HouseVo houseVo, String[] rentalList) {
        if(ArrayUtils.isNotEmpty(rentalList)){
            // 存储转换结果
            List<Map<String,Integer>> rentalMapList = new ArrayList<>();

            // rentalList = [100-1000,1000-1500]
            for(String rental: rentalList){
                String[] rentalArray = rental.split("-");
                Map<String, Integer> rentalMap = new HashMap<>();
                rentalMap.put("start",Integer.valueOf(rentalArray[0]));
                rentalMap.put("end",Integer.valueOf(rentalArray[1]));
                rentalMapList.add(rentalMap);
            }
            houseVo.setRentalMapList(rentalMapList);
        }
    }

    @Override
    public int updateHouse(House house) {
        if(house.getCity() != null){
            Area area = areaMapper.queryById(house.getArea());
            house.setAreaName(area.getName());
        }
        return houseMapper.updateHouse(house);
    }

}
