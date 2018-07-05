package com.jwxt.dao.ydj;

import com.jwxt.model.ydj.YdjAdmin;

public interface YdjAdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(YdjAdmin record);

    int insertSelective(YdjAdmin record);

    YdjAdmin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YdjAdmin record);

    int updateByPrimaryKey(YdjAdmin record);
}