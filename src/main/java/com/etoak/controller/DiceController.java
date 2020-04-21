package com.etoak.controller;

import com.etoak.bean.Dict;
import com.etoak.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dict")
@Slf4j
@Api(tags = "字典查询服务")
public class DiceController {

    @Autowired
    DictService dictService;

    @ApiOperation(value = "根据groupId查询字典列表",notes ="根据groupId查询字典列表")
    @ApiImplicitParam(value = "字典组id",name = "groupId",
    required = true,paramType = "path")
    @GetMapping("/{groupId}")
    public List<Dict> queryList(@PathVariable("groupId") String groupId){
        log.info("groupId -{}",groupId);
        return dictService.queryList(groupId);
    }
}
