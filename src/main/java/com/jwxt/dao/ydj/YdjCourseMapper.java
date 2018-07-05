package com.jwxt.dao.ydj;

import com.jwxt.model.ydj.YdjCourse;

import java.util.List;

public interface YdjCourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(YdjCourse record);

    int insertSelective(YdjCourse record);

    YdjCourse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YdjCourse record);

    int updateByPrimaryKey(YdjCourse record);

	List<String> queryCourseByClassId(String studentClassId);
}