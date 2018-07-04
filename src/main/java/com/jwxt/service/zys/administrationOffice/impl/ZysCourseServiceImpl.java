package com.jwxt.service.zys.administrationOffice.impl;

import com.jwxt.dao.zys.administrationOffice.ZysCourseMapper;
import com.jwxt.model.zys.administrationOffice.ZysCourse;
import com.jwxt.model.zys.administrationOffice.ZysCourseVo;
import com.jwxt.service.zys.administrationOffice.ZysCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZysCourseServiceImpl implements ZysCourseService {
	@Autowired
	private ZysCourseMapper courseMapper;

	@Override
	public List<ZysCourseVo> queryCourseByParam(String classId, String courseYear, String courseSemester) {
		return courseMapper.queryCourseByParam(classId,courseYear,courseSemester);
	}

	@Override
	public String addCourse(ZysCourse course) {
		ZysCourse tempCourse = courseMapper.selectCourseByParam(course.getCourseClassId(), course.getCourseYear(), course.getCourseSemester(), course.getCoursePeriod());
		String msg = "";
		if (tempCourse!=null) {
			msg = "repeated";
		}else {
			msg = "success";
			courseMapper.insertSelective(course);
		}
		
		return msg;
	}

	@Override
	public int deleteCourseById(String courseId) {
		return courseMapper.deleteByPrimaryKey(courseId);
	}

	@Override
	public ZysCourse getCourseById(String courseId) {
		return courseMapper.selectByPrimaryKey(courseId);
	}

	@Override
	public int updateCourseByCourse(ZysCourse course) {
		return courseMapper.updateByPrimaryKeySelective(course);
	}
}
