package com.etoak.mapper;

import com.etoak.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户名查询用户
     * @return
     */
    User queryByName(@Param("name") String name);
}
