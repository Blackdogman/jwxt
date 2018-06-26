package com.jwxt.controller.administrationOffice;

import com.framework.controller.BaseController;
import com.framework.utils.PrimaryKeyUtil;
import com.jwxt.model.system.Student;
import com.jwxt.service.administrationOffice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/studentController")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/addStudent.do")
    public String addStudent(Student student, Model model){
        student.setId(PrimaryKeyUtil.getPrimaryKey());
        int haveUser = studentService.userExist(student.getStudentId());
        if(haveUser == 1){
            //已经存在该学号（工号）的用户了
            model.addAttribute("errorMessage", "用户已经存在");
            return "view/administrationOffice/studentAdd";
        }
        int flag = studentService.addStudent(student);
        return null;
    }
}
