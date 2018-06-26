package com.jwxt.service.administrationOffice;

import com.jwxt.model.system.Student;

public interface StudentService {
    int addStudent(Student student);

    int userExist(String studentId);
}
