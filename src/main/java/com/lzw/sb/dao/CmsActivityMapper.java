package com.lzw.sb.dao;

import com.lzw.sb.model.CmsActivity;

public interface CmsActivityMapper {
    int deleteByPrimaryKey(String ids);

    int insert(CmsActivity record);

    int insertSelective(CmsActivity record);

    CmsActivity selectByPrimaryKey(String ids);

    int updateByPrimaryKeySelective(CmsActivity record);

    int updateByPrimaryKeyWithBLOBs(CmsActivity record);

    int updateByPrimaryKey(CmsActivity record);
}