package com.lzw.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lzw.sb.dao.CmsActivityMapper;
import com.lzw.sb.model.CmsActivity;
@Component
public class CmsActivityService {
	@Autowired
	CmsActivityMapper cmsActivityMapper;
	public CmsActivity getCmsActivity(String ids){
		return cmsActivityMapper.selectByPrimaryKey(ids);
	}
}
