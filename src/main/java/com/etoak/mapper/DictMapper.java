package com.etoak.mapper;

import com.etoak.bean.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {
    /**
     * 根据groupId查询字典列表
     * @param groupId
     * @return
     */
    List<Dict> queryList(@Param("groupId") String groupId);
}
