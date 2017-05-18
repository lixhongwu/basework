package com.lzw.sb.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {
	@RequestMapping("/404")
    public String fourzerofour(Map<String,Object> map){
		return "common/404";
	}
	@RequestMapping("/405")
    public String fourzerofive(Map<String,Object> map){
		return "common/405";
	}
}
