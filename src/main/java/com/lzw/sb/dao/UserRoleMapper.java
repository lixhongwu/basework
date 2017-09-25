package com.lzw.sb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzw.sb.model.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole> {

    int insertSelective(UserRole record);
}