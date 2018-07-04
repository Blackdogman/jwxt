package com.jwxt.controller.zys.administrationOffice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwxt.model.zys.administrationOffice.ZysClassInfo;
import com.jwxt.model.zys.administrationOffice.ZysCourse;
import com.jwxt.model.zys.administrationOffice.ZysCourseVo;
import com.jwxt.model.zys.dictionary.ZysDictionary;
import com.jwxt.model.zys.teacher.ZysTeacher;
import com.jwxt.service.zys.administrationOffice.ZysClassInfoService;
import com.jwxt.service.zys.administrationOffice.ZysCourseService;
import com.jwxt.service.zys.dictionary.ZysDictionaryService;
import com.jwxt.service.zys.teacher.ZysTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.framework.utils.PrimaryKeyUtil;


/**
 * <p>
 * 课程管理
 * </p>
 *
 * @author zys
 * @Copyright (C), 华清远见
 * @Date:2018年6月28日
 */
@Controller
@RequestMapping("/courseController")
public class CourseController {
    @Autowired
    private ZysClassInfoService classInfoService;
    @Autowired
    private ZysCourseService courseService;
    @Autowired
    private ZysDictionaryService dictionaryService;
    @Autowired
    private ZysTeacherService teacherService;

    /**  */
    private static final long serialVersionUID = 3012042037713099817L;

    /**
     * <p>
     * 二级联动班级菜单
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @return
     * @author zys
     * @Date 2018年6月28日
     */
    @RequestMapping("/classListUI.do")
    @ResponseBody
    public Map<String, Object> classListUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                                           int classGraduateYear) {

        List<ZysClassInfo> classInfoList = classInfoService.queryClassInfoByGraduateYear(classGraduateYear);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("classInfo", classInfoList);
        return map;
    }

    /**
     * <p>
     * 查询课表
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classId
     * @param courseYear
     * @param courseSemester
     * @return
     * @author zys
     * @Date 2018年6月29日
     */
    @RequestMapping("/courseList.do")
    public String courseList(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                             @RequestParam(value = "classGraduateYear", defaultValue = "0") int classGraduateYear,
                             @ModelAttribute("classId") String classId, @ModelAttribute("courseYear") String courseYear, @ModelAttribute("courseSemester") String courseSemester) {
        //构造毕业年下拉菜单数据
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        year -= 5;
        List<Integer> yearList = new ArrayList<>();
        yearList.add(year);
        for (int i = 1; i <= 10; i++) {
            year++;
            yearList.add(year);
        }

        //传给前台
        model.addAttribute("yearList", yearList);

        //查询课程数据
        List<ZysCourseVo> courseList = new ArrayList<>();
        if (classId != null && courseYear != null && courseSemester != null) {
            courseList = courseService.queryCourseByParam(classId, courseYear, courseSemester);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        for (ZysCourseVo cVo : courseList) {
            String key = (cVo.getCoursePeriod() + "-" + cVo.getCourseWeekday());
            map.put(key, cVo);
        }
        System.out.println(map);
        //传给前台
        model.addAttribute("courseMap", map);

        return "view/zys/administrationOffice/course/course_list";
    }

    /**
     * <p>
     *
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classId
     * @param courseYear
     * @param courseSemester
     * @return
     * @author zys
     * @Date 2018年7月2日
     */
    @RequestMapping("/addUI.do")
    public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                        @ModelAttribute("classId") String classId, @ModelAttribute("courseYear") String courseYear, @ModelAttribute("courseSemester") String courseSemester,
                        @ModelAttribute("msg") String msg) {

        System.out.println(classId);
        System.out.println(courseYear);
        System.out.println(courseSemester);
        System.out.println(msg);

        //构造年份下拉菜单数据
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        year -= 5;
        List<Integer> yearList = new ArrayList<>();
        yearList.add(year);
        for (int i = 1; i <= 10; i++) {
            year++;
            yearList.add(year);
        }
        //传给前台
        model.addAttribute("yearList", yearList);

        //查询所有科目,构造科目下拉菜单数据
        String type = "科目";
        List<ZysDictionary> subjectList = dictionaryService.queryDictionaryByType(type);
        //传给前台
        model.addAttribute("subjectList", subjectList);

        //查询所有在职老师,构造老师下拉菜单数据
        List<Integer> statusList = new ArrayList<>();
        int status = 1;
        statusList.add(status);
        List<ZysTeacher> teacherList = teacherService.queryTeahcerByStatus(statusList);
        //传给前台
        model.addAttribute("teacherList", teacherList);

        //查询班级的信息
        ZysClassInfo classInfo = classInfoService.queryClassInfoById(classId);
        //传给前台
        model.addAttribute("classInfo", classInfo);
        model.addAttribute("courseYear", courseYear);
        model.addAttribute("courseSemester", courseSemester);
        model.addAttribute("msg", msg);

        return "view/zys/administrationOffice/course/course_add";
    }

    /**
     * <p>
     * 添加课程
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param subject
     * @param courseTeacherId
     * @param classId
     * @param courseYear
     * @param courseSemester
     * @param courseWeekday
     * @param coursePeriod
     * @return
     * @author zys
     * @Date 2018年7月2日
     */
    @RequestMapping("/add.do")
    public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, RedirectAttributes attr,
                      String subject, String courseTeacherId, String classId, String courseYear, String courseSemester, String courseWeekday, String coursePeriod) {
        //添加课程信息
        ZysCourse course = new ZysCourse();
        course.setId(PrimaryKeyUtil.getPrimaryKey());
        course.setCourseClassId(classId);
        course.setCoursePeriod(coursePeriod);
        course.setCourseSemester(courseSemester);
        course.setCourseSubjectId(subject);
        course.setCourseTeacherId(courseTeacherId);
        course.setCourseWeekday(courseWeekday);
        course.setCourseYear(courseYear);
        String msg = courseService.addCourse(course);
        attr.addFlashAttribute("msg", msg);
        attr.addFlashAttribute("classId", classId);
        attr.addFlashAttribute("courseYear", courseYear);
        attr.addFlashAttribute("courseSemester", courseSemester);

        return "redirect:/courseController/addUI.do";
    }

    /**
     * <p>
     * 为添加页面查询课表
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classId
     * @param courseYear
     * @param courseSemester
     * @return
     * @author zys
     * @Date 2018年7月3日
     */
    @RequestMapping("/addCourseList.do")
    @ResponseBody
    public Map<String, Object> addCourseList(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                                             String classId, String courseYear, String courseSemester) {

        //查询课程数据
        List<ZysCourseVo> courseList = new ArrayList<>();
        if (classId != null && courseYear != null && courseSemester != null) {
            courseList = courseService.queryCourseByParam(classId, courseYear, courseSemester);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        for (ZysCourseVo cVo : courseList) {
            String key = (cVo.getCoursePeriod() + "-" + cVo.getCourseWeekday());
            map.put(key, cVo);
        }

        System.out.println(map);
        return map;
    }

    /**
     * <p>
     * 删除课程
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param courseId
     * @return
     * @author zys
     * @Date 2018年7月3日
     */
    @RequestMapping("/delete.do")
    public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, RedirectAttributes attr,
                         String courseId) {
        //根据课程id查询课程
        ZysCourse course = courseService.getCourseById(courseId);
        attr.addFlashAttribute("classId", course.getCourseClassId());
        attr.addFlashAttribute("courseYear", course.getCourseYear());
        attr.addFlashAttribute("courseSemester", course.getCourseSemester());

        int n = courseService.deleteCourseById(courseId);
        return "redirect:/courseController/courseList.do";
    }

    /**
     * <p>
     * 为修改页面准备数据
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param courseId
     * @return
     * @author zys
     * @Date 2018年7月3日
     */
    @RequestMapping("/updateUI.do")
    public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                           String courseId) {
        //查询所有科目,构造科目下拉菜单数据
        String type = "科目";
        List<ZysDictionary> subjectList = dictionaryService.queryDictionaryByType(type);
        //传给前台
        model.addAttribute("subjectList", subjectList);

        //查询所有在职老师,构造老师下拉菜单数据
        List<Integer> statusList = new ArrayList<>();
        int status = 1;
        statusList.add(status);
        List<ZysTeacher> teacherList = teacherService.queryTeahcerByStatus(statusList);
        //传给前台
        model.addAttribute("teacherList", teacherList);

        //根据课程id查询课程
        ZysCourse course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);

        //查询班级的信息
        ZysClassInfo classInfo = classInfoService.queryClassInfoById(course.getCourseClassId());
        //传给前台
        model.addAttribute("classInfo", classInfo);

        return "view/zys/administrationOffice/course/course_update";
    }


    /**
     * <p>
     * 修改课程
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param attr
     * @param course
     * @return
     * @author zys
     * @Date 2018年7月3日
     */
    @RequestMapping("/update.do")
    public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, RedirectAttributes attr,
                         ZysCourse course) {
        attr.addFlashAttribute("classId", course.getCourseClassId());
        attr.addFlashAttribute("courseYear", course.getCourseYear());
        attr.addFlashAttribute("courseSemester", course.getCourseSemester());

        int n = courseService.updateCourseByCourse(course);

        return "redirect:/courseController/courseList.do";
    }
}
