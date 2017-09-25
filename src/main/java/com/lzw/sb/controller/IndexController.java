package com.lzw.sb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.lzw.sb.dao.UserMapper;
import com.lzw.sb.model.User;
import com.lzw.sb.service.CmsActivityService;
import com.lzw.sb.service.UserService;
@Controller

public class IndexController {
	@Autowired
	UserService userService;
	@Autowired
    private UserMapper userMapper; 
	@RequestMapping("/index")
    public String hello(Map<String,Object> map){
		EntityWrapper ew=new EntityWrapper();
		ew.setEntity(new User());
	     String name="admins";
	     Page page=new Page(1,10);
	     Page<User> u=userService.selectUserPage(page,"NORMAL");
		 System.out.println(u.getSize());
		 User tUser2 = userMapper.findByName("admins"); 
		return "base/index";
	}
}
