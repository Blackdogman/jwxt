package com.jwxt.service.administrationOffice;

import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.system.StudentVo;
import com.jwxt.model.system.Teacher;
import com.jwxt.model.system.TeacherVo;

public interface TeacherService {
    int addTeacher(Teacher teacher);

    PagedResult<TeacherVo> listAllTeacher(Integer pageNumber, Integer pageSize, TeacherVo teacherVo);
}
