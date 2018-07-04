package com.jwxt.controller.sc.teacher;

import com.jwxt.model.sc.*;
import com.jwxt.model.system.SysUser;
import com.jwxt.service.sc.teacher.ScCourseService;
import com.jwxt.service.sc.teacher.ScScoreService;
import com.jwxt.service.sc.teacher.ScTeacherService;
import com.jwxt.service.sc.teacher.ScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author suchen
 * @Copyright (C), 布朗先生
 * @Date:2018年6月27日
 */
@Controller
@RequestMapping("TeacherController")

public class TeacherController {
    @Autowired
    private ScTeacherService teacherservice;
    @Autowired
    private ScUserService userService;
    @Autowired
    private ScCourseService courseService;
    @Autowired
    private ScScoreService scoreService;
    /**  */
    private static final long serialVersionUID = -1946926049646497072L;

    @RequestMapping("/list.do")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                        ScTeacher teac, String userLoginName) {
        System.out.println(userLoginName);
        userLoginName = ((SysUser)(session.getAttribute("loginUser"))).getUserLoginName();
        /**个人信息查询界面 根据用户名拿到用户ID */
        String teacher_id = userService.seletTidbyname(userLoginName);
        /**根据ID拿到教师表中的个人信息 */
        List<ScTeacher> teach = teacherservice.selectByTeacherAll(teacher_id);
        model.addAttribute("teacherList", teach);
        return "view/sc/teacher/list";
    }

    @RequestMapping("/lesson.do")
    public String lesson(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                         ScTeacher teac, String userLoginName) {
        userLoginName = ((SysUser)(session.getAttribute("loginUser"))).getUserLoginName();
        /**课程表查询根据用户名拿到用户ID  */
        String teacher_id = userService.seletTidbyname(userLoginName);
        /**根据用户ID拿到用户课程信息  */
        List<ScCourse> cou = courseService.selectByTeacherId(teacher_id);
        for (ScCourse course1 : cou) {
            System.out.println(course1);
        }

        /**创建一个映射类scorview,利用scoreview类对象拿到课程名称，课程星期数和课程课时  */

        List<ScScoreView> cour = courseService.selectCourseById(teacher_id);
        for (ScScoreView scoreView : cour) {
            System.out.println(scoreView);
        }
        model.addAttribute("course", cour);
        return "view/sc/teacher/lesson";
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                           String teacherId) {
        /**更改密码  */
        System.out.println(teacherId);
        ScUser a = userService.selectByPrimaryKeyAndStatus(teacherId);
        if (a != null) {
            model.addAttribute("teacherId", teacherId);
            return "view/sc/teacher/update";
        } else {
            return "view/frame/index";
        }
    }

    @RequestMapping("/update.do")
    public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                         String teacherId, String userLoginPwd) {
        /** 更改密码 */
        ScUser us = new ScUser();
        us.setUserLoginPwd(userLoginPwd);
        us.setUserId(teacherId);
        System.out.println(us);
        userService.updateByPrimaryKeySelective(us);
        return "redirect:/TeacherController/list.do";
    }

    @RequestMapping("/score.do")
    public String score(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                        String userLoginName) {
        userLoginName = ((SysUser)(session.getAttribute("loginUser"))).getUserLoginName();
        /** 成绩查询 拿到用户ID */
        String teacher_id = userService.seletTidbyname(userLoginName);
        //ID查询课程
        List<ScScore> sco = scoreService.seletByTeacherId(teacher_id);
        for (ScScore score : sco) {
            System.out.println(score);
        }
        List<Object> allscore = new ArrayList<Object>();
        //把得到的viewl类的值存入泛型类中
        allscore = scoreService.selectNameAndScoreByTid(teacher_id);
        for (int i = 0; i < allscore.size(); i++) {
            System.out.println(allscore.get(i));
        }
        model.addAttribute("score", allscore);
        return "view/sc/teacher/score";
    }

}
