package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScTeacher;

import java.util.List;

public interface ScTeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScTeacher record);

    int insertSelective(ScTeacher record);

    ScTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScTeacher record);

    int updateByPrimaryKey(ScTeacher record);

	List<ScTeacher> selectByTeacherAll(String teacher_id);
}