package com.lzw.sb.dao;

import com.lzw.sb.model.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}