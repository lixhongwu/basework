package com.lzw.sb.dao;

import java.util.Collection;
import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzw.sb.model.Permission;
import com.lzw.sb.model.Role;

public interface RoleMapper extends BaseMapper<Role> {
    Integer insert(Role record);

    int insertSelective(Role record);

	List<String> getPermissionsName(Role role);
}