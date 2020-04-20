package com.etoak.controller;

import com.etoak.bean.Area;
import com.etoak.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
@Slf4j
public class AreaController {
    /**
     * 地区查询接口 ，查询省列表
     * @param pid
     * @return
     */
    @Autowired
    AreaService areaService;

    @GetMapping("/queryByPid")
    @ApiOperation(value = "根据父id查询地区列表",notes = "根据父id查询地区列表")
    @ApiImplicitParam(value = "父id",name = "pid",required = false,
            defaultValue = "0",paramType = "query")
    public List<Area> queryByPid(@RequestParam(required = false,defaultValue = "0")int pid){
        log.info("pid - {}",pid);
        return areaService.queryByPid(pid);
    }
}
