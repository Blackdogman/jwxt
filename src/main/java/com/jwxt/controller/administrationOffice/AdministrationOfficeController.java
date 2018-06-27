package com.jwxt.controller.administrationOffice;

import com.framework.controller.BaseController;
import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.system.Student;
import com.jwxt.model.system.StudentVo;
import com.jwxt.model.system.Teacher;
import com.jwxt.service.administrationOffice.StudentService;
import com.jwxt.service.administrationOffice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/administrationOfficeController")
public class AdministrationOfficeController extends BaseController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/studentListUi.do", produces = "application/json;charset=utf-8")
    public String studentListUi(
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            StudentVo studentVo,
            Model model) {
        studentVo.setStudentId(studentVo.getStudentName());
        PagedResult<StudentVo> pagedResult = studentService.listAllStudent(pageNumber, pageSize, studentVo);
        model.addAttribute("pageResult", pagedResult);
        return "view/administrationOffice/student/studentList";
    }

    @RequestMapping("/addStudent.do")
    public String addStudent(Student student, Model model) {
        student.setId(PrimaryKeyUtil.getPrimaryKey());
        int haveUser = studentService.userExist(student.getStudentId());
        if (haveUser == 1) {
            //已经存在该学号（工号）的用户了
            model.addAttribute("errorMessage", "用户已经存在");
            return "view/administrationOffice/student/studentAdd";
        }
        int flag = studentService.addStudent(student);
        return null;
    }

    @RequestMapping("/deleteStudent.do")
    public String deleteStudent(String studentId){
        int haveUser = studentService.userExist(studentId);
        if(haveUser == 1){
            int flag = studentService.deleteStudentByStudentId(studentId);
        }
        return "redirect:/administrationOfficeController/studentListUi.do";
    }

    @RequestMapping("/addTeacher.do")
    public String addTeacher(Teacher teacher, Model model) {
        teacher.setId(PrimaryKeyUtil.getPrimaryKey());
        int haveUser = studentService.userExist(teacher.getTeacherId());
        if (haveUser == 1) {
            //已经存在该学号（工号）的用户了
            model.addAttribute("errorMessage", "用户已经存在");
            return "view/administrationOffice/teacher/teacherAdd";
        }
        int flag = teacherService.addTeacher(teacher);
        return null;
    }
}
