package com.jwxt.dao.ydj;

import com.jwxt.model.ydj.YdjClassInfo;

public interface YdjClassInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(YdjClassInfo record);

    int insertSelective(YdjClassInfo record);

    YdjClassInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YdjClassInfo record);

    int updateByPrimaryKey(YdjClassInfo record);

    YdjClassInfo queryClassById(String studentClassId);
}