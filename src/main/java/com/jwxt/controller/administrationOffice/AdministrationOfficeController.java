package com.jwxt.controller.administrationOffice;

import com.framework.controller.BaseController;
import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.administrationOffice.ClassInfoVo;
import com.jwxt.model.system.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/administrationOfficeController")
public class AdministrationOfficeController extends BaseController {

    /**
     * 学生列表UI
     */
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

    /**
     * 添加学生
     *
     * @param student 表单提交的学生模型
     */
    @RequestMapping("/addStudent.do")
    public String addStudent(Student student, Model model) {
        student.setId(PrimaryKeyUtil.getPrimaryKey());
        int haveUser = sysUserService.userExist(student.getStudentId());
        if (haveUser == 1) {
            //已经存在该学号（工号）的用户了
            model.addAttribute("errorMessage", "用户已经存在");
            return "view/administrationOffice/student/studentAdd";
        }
        int flag = studentService.addStudent(student);
        if(flag > 0){
            return "redirect:/administrationOfficeController/studentListUi.do";
        }else {
            model.addAttribute("errorMessage", "添加学生异常");
            return "view/administrationOffice/student/studentAdd";
        }
    }

    /**
     * 删除学生
     *
     * @param studentId 要删除学生的学号
     */
    @RequestMapping("/deleteStudent.do")
    public String deleteStudent(String studentId) {
        int haveUser = sysUserService.userExist(studentId);
        if (haveUser == 1) {
            studentService.deleteStudentByStudentId(studentId);
        }
        return "redirect:/administrationOfficeController/studentListUi.do";
    }

    /**
     * 老师列表Ui
     */
    @RequestMapping(value = "/teacherListUi.do", produces = "application/json;charset=utf-8")
    public String studentListUi(
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            TeacherVo teacherVo,
            Model model) {
        teacherVo.setTeacherId(teacherVo.getTeacherName());
        PagedResult<TeacherVo> pagedResult = teacherService.listAllTeacher(pageNumber, pageSize, teacherVo);
        model.addAttribute("pageResult", pagedResult);
        return "view/administrationOffice/teacher/teacherList";
    }

    /**
     * 添加老师
     *
     * @param teacher 表单提交的老师数据
     */
    @RequestMapping("/addTeacher.do")
    public String addTeacher(Teacher teacher, Model model) {
        teacher.setId(PrimaryKeyUtil.getPrimaryKey());
        int haveUser = sysUserService.userExist(teacher.getTeacherId());
        if (haveUser == 1) {
            //已经存在该学号（工号）的用户了
            model.addAttribute("errorMessage", "用户已经存在");
            return "view/administrationOffice/teacher/teacherAdd";
        }
        int flag = teacherService.addTeacher(teacher);
        if(flag >0){
            return "redirect:/administrationOfficeController/teacherListUi.do";
        }else {
            model.addAttribute("errorMessage", "添加失败");
            return "view/administrationOffice/teacher/teacherAdd";
        }

    }

    @RequestMapping("/deleteTeacher.do")
    public String deleteTeacher(String teacherId) {
        int haveUser = sysUserService.userExist(teacherId);
        if (haveUser == 1) {
            teacherService.deleteTeacherByTeacherId(teacherId);
        }
        return "redirect:/administrationOfficeController/teacherListUi.do";
    }

    /**
     * 考试添加页面
     */
    @RequestMapping("/examAddUi.do")
    public String examAddUi(Model model) {
        List<Map<String, String>> xuekeDictionary = dictionaryTools.listDictionaryNameByType("科目");
        List<Map<String, String>> kaoshiDictionary = dictionaryTools.listDictionaryNameByType("考试");
        List<ClassInfoVo> classInfoVoList = classInfoService.listClassInfoVoByYearAndName(null);
        model.addAttribute("xuekeDictionary", xuekeDictionary);
        model.addAttribute("kaoshiDictionary", kaoshiDictionary);
        model.addAttribute("classList", classInfoVoList);
        return "view/administrationOffice/score/examAdd";
    }

    /**
     * 添加分数页面跳转
     *
     * @param model Model对象
     * @return 添加分数页面路径
     */
    @RequestMapping("/scoreAddUi.do")
    public String scoreAddUi(Model model) {
        List<Map<String, String>> kaoshiDictionary = dictionaryTools.listDictionaryNameByType("考试");
        model.addAttribute("kaoshiDictionary", kaoshiDictionary);
        return "view/administrationOffice/score/scoreAdd";
    }

    /**
     * 添加成绩点击班级后得到具体的学生列表
     *
     * @param classId 班级ID
     * @return StudentVo集合
     */
    @RequestMapping("/scoreStudentUi.do")
    public String scoreStudentUi(String classId, Model model) {
        List<StudentVo> studentVoList = studentService.listStudentVoByClassId(classId); //这里得到班级对应的所有StudentVo对象
        model.addAttribute("classId", classId);
        model.addAttribute("studentList", studentVoList);
        return "view/administrationOffice/score/scoreAddStudentList";
    }

    /**
     * 学生页面的跳转ui,展示该学生未提交成绩的考试
     *
     * @param studentId 学生的ID
     * @return 前往对应页面并携带该学生的ScoreVo对象
     */
    @RequestMapping("/studentExamUi.do")
    public String studentExamUi(String studentId, Model model) {
        List<ScoreVo> scoreVoList = scoreService.listScoreVoByStudentId(studentId);
        model.addAttribute("scoreList", scoreVoList);
        return "view/administrationOffice/score/scoreAddStudentScoreList";
    }

}
