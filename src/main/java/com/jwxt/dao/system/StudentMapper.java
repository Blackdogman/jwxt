package com.jwxt.dao.system;

import com.jwxt.model.system.Student;
import com.jwxt.model.system.StudentVo;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<StudentVo> listAllUser(StudentVo studentVo);

    int deleteStudentByStudentId(String studentId);

    List<Student> selectByClassId(String classId);

    List<StudentVo> listStudentVoByClassId(String classId);

    List<StudentVo> listStudentVoByClassIdAndStudentName(Map<String,Object> parmMap);
}