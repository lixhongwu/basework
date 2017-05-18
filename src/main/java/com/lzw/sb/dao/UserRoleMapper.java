package com.lzw.sb.dao;

import com.lzw.sb.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}