package com.etoak.service.impl;

import com.etoak.bean.Area;
import com.etoak.mapper.AreaMapper;
import com.etoak.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaMapper areaMapper;

    @Override
    public List<Area> queryByPid(int pid) {
        return areaMapper.queryByPid(pid);
    }
}
