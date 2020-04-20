package com.etoak.service;

import com.etoak.bean.Area;

import java.util.List;

public interface AreaService {

    List<Area> queryByPid(int pid);
}
