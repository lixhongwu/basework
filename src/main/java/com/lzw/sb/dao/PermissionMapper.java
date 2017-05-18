package com.lzw.sb.dao;

import com.lzw.sb.model.Permission;

public interface PermissionMapper {
    int insert(Permission record);

    int insertSelective(Permission record);
}