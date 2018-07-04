package com.jwxt.service.zys.teacher;

import com.jwxt.model.zys.teacher.ZysTeacher;

import java.util.List;


public interface ZysTeacherService {

	List<ZysTeacher> queryTeahcerByStatus(List<Integer> statusList);

}
