package com.jwxt.service.administrationOffice;

import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.administrationOffice.ClassInfoVo;
import com.jwxt.model.system.Student;
import com.jwxt.model.system.StudentVo;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    PagedResult<StudentVo> listAllStudent(Integer pageNumber, Integer pageSize, StudentVo studentVo);

    int deleteStudentByStudentId(String studentId);

    List<StudentVo> listStudentVoByClassId(String classId);

    List<StudentVo> listStudentVoByClassIdAndStudentName(String studentName, String classId);
}
