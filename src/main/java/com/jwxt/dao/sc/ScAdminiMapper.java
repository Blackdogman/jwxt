package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScAdmini;

public interface ScAdminiMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScAdmini record);

    int insertSelective(ScAdmini record);

    ScAdmini selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScAdmini record);

    int updateByPrimaryKey(ScAdmini record);
}