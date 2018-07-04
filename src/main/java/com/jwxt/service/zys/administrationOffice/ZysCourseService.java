package com.jwxt.service.zys.administrationOffice;


import com.jwxt.model.zys.administrationOffice.ZysCourse;
import com.jwxt.model.zys.administrationOffice.ZysCourseVo;

import java.util.List;

public interface ZysCourseService {

	List<ZysCourseVo> queryCourseByParam(String classId, String courseYear, String courseSemester);

	String addCourse(ZysCourse course);

	int deleteCourseById(String courseId);

	ZysCourse getCourseById(String courseId);

	int updateCourseByCourse(ZysCourse course);


}
