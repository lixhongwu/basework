package com.lzw.sb.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.lzw.sb.model.Permission;
import com.lzw.sb.model.Role;
import com.lzw.sb.model.User;

public interface UserMapper extends BaseMapper<User> {
	
	@Select("selectUserList")
	List<User> selectUserList(Pagination page,String state);
	  
	User findByName(String loginName);

	Set<String> getRolesName(User user);

	List<Role> getRoleList(User user);

}