package com.lzw.sb.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzw.sb.dao.UserMapper;
import com.lzw.sb.model.User;
@Service
public class UserService extends ServiceImpl<UserMapper, User>{
	 public Page<User> selectUserPage(Page<User> page, String state) {
	        page.setRecords(baseMapper.selectUserList(page,state));
	        return page;
	 }
}
