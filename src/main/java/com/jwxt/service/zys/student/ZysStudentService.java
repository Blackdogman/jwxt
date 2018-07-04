package com.jwxt.service.zys.student;

import com.jwxt.model.zys.student.ZysStudent;

import java.util.List;

public interface ZysStudentService {

	List<ZysStudent> queryStudentByStatus(List<Integer> statusList);

	List<ZysStudent> queryDistributedStudentByClassId(String id);

}
