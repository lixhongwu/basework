package com.lzw.sb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzw.sb.model.Permission;

public interface PermissionMapper  extends BaseMapper<Permission> {

    int insertSelective(Permission record);
}