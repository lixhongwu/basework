package com.lzw.sb.dao;

import java.util.List;

import com.lzw.sb.model.CmsActivity;

public interface CmsActivityMapper {
	
	List<CmsActivity> list(CmsActivity record);
	 
    int deleteByPrimaryKey(String ids);

    int insert(CmsActivity record);

    int insertSelective(CmsActivity record);

    CmsActivity selectByPrimaryKey(String ids);

    int updateByPrimaryKeySelective(CmsActivity record);

    int updateByPrimaryKeyWithBLOBs(CmsActivity record);

    int updateByPrimaryKey(CmsActivity record);
}