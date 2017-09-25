package com.lzw.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CmsActivityService {
	public void intt(){
		System.out.println(23423);
	}
//	@Autowired
//	CmsActivityMapper cmsActivityMapper;
//	public CmsActivity getCmsActivity(String ids){
//		return cmsActivityMapper.selectByPrimaryKey(ids);
//	}
//	public PageInfo<CmsActivity> getList(CmsActivity cmsActivity){
//		  if(cmsActivity.getPage()!= null && cmsActivity.getRows()!= null){  
//	            PageHelper.startPage(cmsActivity.getPage(), cmsActivity.getRows());  
//	        }  
//	        List<CmsActivity> cms = cmsActivityMapper.list(cmsActivity);  
//	        return new PageInfo<CmsActivity>(cms); 
//	}
}
