package com.lzw.sb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lzw.sb.model.CmsActivity;
import com.lzw.sb.service.CmsActivityService;

@Controller
public class HelloController {
	@Autowired
	CmsActivityService cmsActivityService;
		@RequestMapping("/hello")
	    public String hello(Map<String,Object> map){
	       map.put("name", "[Angel -- 守护天使2015]");
	       System.out.println("-----------");
	       CmsActivity cmsActivity= cmsActivityService.getCmsActivity("0a7e3a5107494691a1419d1382d34b20");
	       map.put("cmsActivity", cmsActivity);
	       return "hello";
	    }
		@RequestMapping("/list")
	    public String list(Map<String,Object> map){
			 CmsActivity cmsActivity =new  CmsActivity();
			PageInfo<CmsActivity> model= cmsActivityService.getList(cmsActivity);
			System.out.println(model.getList().get(0));
	       map.put("model", model);
	       return "list";
	    }
}
