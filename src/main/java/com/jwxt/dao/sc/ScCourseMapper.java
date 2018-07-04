package com.jwxt.dao.sc;

import com.jwxt.model.sc.ScCourse;
import com.jwxt.model.sc.ScScoreView;

import java.util.List;

public interface ScCourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScCourse record);

    int insertSelective(ScCourse record);

    ScCourse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScCourse record);

    int updateByPrimaryKey(ScCourse record);

	List<ScCourse> selectByTeacherId(String teacher_id);

	List<ScScoreView> selectCourseById(String teacher_id);
}