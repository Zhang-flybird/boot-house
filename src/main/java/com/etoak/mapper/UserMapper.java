package com.etoak.mapper;

import com.etoak.bean.User;

public interface UserMapper {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
}
