package com.jwxt.service.sc.teacher;

import com.jwxt.model.sc.ScCourse;
import com.jwxt.model.sc.ScScoreView;

import java.util.List;

public interface ScCourseService {

	List<ScCourse> selectByTeacherId(String teacher_id);

	List<ScScoreView> selectCourseById(String teacher_id);

}
