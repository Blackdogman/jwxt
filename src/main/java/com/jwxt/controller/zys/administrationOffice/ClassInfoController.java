package com.jwxt.controller.zys.administrationOffice;

import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.zys.administrationOffice.ZysClassInfo;
import com.jwxt.model.zys.administrationOffice.ZysClassInfoVo;
import com.jwxt.model.zys.student.ZysStudent;
import com.jwxt.model.zys.teacher.ZysTeacher;
import com.jwxt.service.zys.administrationOffice.ZysClassInfoService;
import com.jwxt.service.zys.student.ZysStudentService;
import com.jwxt.service.zys.teacher.ZysTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * <p>
 * 班级管理
 * </p>
 *
 * @author zys
 * @Copyright (C), 华清远见
 * @Date:2018年6月26日
 */
@Controller
@RequestMapping("/classInfoController")
public class ClassInfoController {
    @Autowired
    private ZysClassInfoService classInfoService;
    @Autowired
    private ZysTeacherService teacherService;
    @Autowired
    private ZysStudentService studentService;

    /**  */
    private static final long serialVersionUID = -4308565530361369955L;

    /**
     * <p>
     * 带分页的班级列表
     * </p>
     *
     * @param pageNumber
     * @param pageSize
     * @return
     * @author zys
     * @Date 2018年6月26日
     */
    //TODO 前台传一个List用来装要查询班级的状态,暂时还没加,现在写死只查有效的班级
    @RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
    public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        ModelAndView mv = new ModelAndView();
        //只查询状态为有效的班级
        List<Integer> statusList = new ArrayList<>();
        int status = 1;
        statusList.add(status);
        // 传入数据到分页工具类
        PagedResult<ZysClassInfoVo> pageResult = classInfoService.getAllByPage(pageNumber, pageSize, statusList);
        // 数据传递到前台页面展示层
        mv.addObject("pageResult", pageResult);
        mv.setViewName("/view/zys/administrationOffice/classInfo/classInfo_list");
        return mv;
    }

    /**
     * <p>
     * 为添加班级页面构造前台数据
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @return
     * @author zys
     * @Date 2018年6月26日
     */
    @RequestMapping("/addUI.do")
    public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        //查询所有在职老师,构造老师下拉菜单数据,用以备选班主任
        List<Integer> statusList = new ArrayList<>();
        int status = 1;
        statusList.add(status);
        List<ZysTeacher> teacherList = teacherService.queryTeahcerByStatus(statusList);

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
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("yearList", yearList);
        return "view/zys/administrationOffice/classInfo/classInfo_add";
    }

    /**
     * <p>
     * 添加新班级
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classInfo
     * @return
     * @author zys
     * @Date 2018年6月26日
     */
    @RequestMapping("/add.do")
    public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                      ZysClassInfo classInfo) {
        //构造数据
        classInfo.setId(PrimaryKeyUtil.getPrimaryKey());
        int u = classInfoService.addClass(classInfo);

        return "redirect:/classInfoController/listPage.do";
    }

    /**
     * <p>
     * 删除班级
     * 此功能只是将班级的状态设为无效，并不从数据库中删除
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classInfo
     * @return
     * @author zys
     * @Date 2018年6月27日
     */
    @RequestMapping("/delete.do")
    public String delect(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                         ZysClassInfo classInfo) {
        int u = classInfoService.setClassStatusToFalse(classInfo);
        return "redirect:/classInfoController/listPage.do";
    }


    /**
     * <p>
     * 班级信息修改页面,前台数据准备
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classInfo
     * @param id
     * @return
     * @author zys
     * @Date 2018年6月27日
     */
    @RequestMapping("/updateUI.do")
    public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                           ZysClassInfo classInfo, String id) {
        //查询所有在职老师,构造老师下拉菜单数据,用以备选班主任
        List<Integer> statusList = new ArrayList<>();
        int status = 1;
        statusList.add(status);
        List<ZysTeacher> teacherList = teacherService.queryTeahcerByStatus(statusList);

        //构造毕业年下拉菜单数据
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        List<Integer> yearList = new ArrayList<>();
        yearList.add(year);
        for (int i = 1; i <= 10; i++) {
            year++;
            yearList.add(year);
        }

        //查询要修改的班级的信息
        ZysClassInfo clssInf = classInfoService.queryClassInfoById(id);
        model.addAttribute("clssInf", clssInf);
        //传给前台
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("yearList", yearList);

        return "view/zys/administrationOffice/classInfo/classInfo_update";
    }


    /**
     * <p>
     * 修改班级信息
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classInfo
     * @return
     * @author zys
     * @Date 2018年6月27日
     */
    @RequestMapping("/update.do")
    public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                         ZysClassInfo classInfo) {
        int n = classInfoService.updateClassInfoByClassInfo(classInfo);
        return "redirect:/classInfoController/listPage.do";
    }


    /**
     * <p>
     * 分配学生页面,前台数据准备
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classInfo
     * @param id
     * @return
     * @author zys
     * @Date 2018年6月27日
     */
    @RequestMapping("/distributeStudentUI.do")
    public String distributeStudentUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                                      ZysClassInfo classInfo, String id) {
        //准备数据【班级对象】
        ZysClassInfo clssInf = classInfoService.queryClassInfoById(id);
        model.addAttribute("classInfo", clssInf);
        //准备数据【学生列表】,只查询在读学生
        List<Integer> statusList = new ArrayList<>();
        int status = 1;
        statusList.add(status);
        List<ZysStudent> studentList = studentService.queryStudentByStatus(statusList);
        model.addAttribute("studentList", studentList);
        //准备数据【已分配的学生】
        List<ZysStudent> distributedStudentList = studentService.queryDistributedStudentByClassId(id);
        List<String> list = new ArrayList<>();
        for (ZysStudent s : distributedStudentList) {
            list.add(s.getStudentId());
        }
        model.addAttribute("ids", list);

        return "view/zys/administrationOffice/classInfo/classInfo_distributeStudent";
    }

    /**
     * <p>
     * 分配学生
     * </p>
     *
     * @param request
     * @param response
     * @param session
     * @param model
     * @param classInfo
     * @param id
     * @param studentIds
     * @return
     * @author zys
     * @Date 2018年6月28日
     */
    @RequestMapping("/distributeStudent.do")
    public String distributeStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                                    ZysClassInfo classInfo, String id, String[] studentIds) {

        //删除原有班级-学生关系
        int m = classInfoService.cleanStudentByClassId(id);
        //分配新班级-学生关系
        List<String> studentIdList = Arrays.asList(studentIds);
        int n = classInfoService.distributeStudent(id, studentIdList);
        return "view/zys/administrationOffice/classInfo/classInfo_distributeStudent_success";
    }

}
