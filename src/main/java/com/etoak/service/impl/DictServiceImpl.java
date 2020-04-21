package com.etoak.service.impl;

import com.etoak.bean.Dict;
import com.etoak.mapper.DictMapper;
import com.etoak.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    DictMapper dictMapper;

    @Override
    public List<Dict> queryList(String groupId) {
        return dictMapper.queryList(groupId);
    }
}
