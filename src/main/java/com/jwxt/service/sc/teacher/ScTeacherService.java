package com.jwxt.service.sc.teacher;

import com.jwxt.model.sc.ScTeacher;

import java.util.List;

public interface ScTeacherService {

    List<ScTeacher> selectByTeacherAll(String teacher_id);

}
