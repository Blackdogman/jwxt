package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScStudent;

public interface ScStudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScStudent record);

    int insertSelective(ScStudent record);

    ScStudent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScStudent record);

    int updateByPrimaryKey(ScStudent record);
}