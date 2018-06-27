package com.jwxt.service.administrationOffice;

import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.system.Student;
import com.jwxt.model.system.StudentVo;

public interface StudentService {
    int addStudent(Student student);

    int userExist(String studentId);


    PagedResult<StudentVo> listAllStudent(Integer pageNumber, Integer pageSize, StudentVo studentVo);

    int deleteStudentByStudentId(String studentId);
}
