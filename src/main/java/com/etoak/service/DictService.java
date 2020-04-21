package com.etoak.service;

import com.etoak.bean.Dict;

import java.util.List;

public interface DictService {

    List<Dict> queryList(String groupId);
}
