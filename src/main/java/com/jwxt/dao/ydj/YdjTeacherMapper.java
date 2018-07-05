package com.jwxt.dao.ydj;


import com.jwxt.model.ydj.YdjTeacher;

public interface YdjTeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(YdjTeacher record);

    int insertSelective(YdjTeacher record);

    YdjTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YdjTeacher record);

    int updateByPrimaryKey(YdjTeacher record);
}