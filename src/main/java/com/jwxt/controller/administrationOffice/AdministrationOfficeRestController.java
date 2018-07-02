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
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/administrationOfficeController")
public class AdministrationOfficeRestController extends BaseController {

    /**
     * examAdd的返回ajax方法
     *
     * @param year      毕业年
     * @param className 班级名称（模糊查询）
     * @return ClassInfoVo的一个集合
     */
    @RequestMapping("/examAddUiJson.do")
    public List<ClassInfoVo> examAddUiJson(String year, String className) {
        ClassInfoVo classInfoVo = new ClassInfoVo();
        if (year != null && year != "") {
            classInfoVo.setClassGraduateYear(year);
        }
        if (className != null && className != "") {
            classInfoVo.setClassName(className);
        }
        List<ClassInfoVo> classInfoVoList = classInfoService.listClassInfoVoByYearAndName(classInfoVo);
        return classInfoVoList;
    }

    /**
     * 添加考试计划
     *
     * @param subject_id 科目ID（字典）
     * @param year       考试年
     * @param semester   考试学期
     * @param examName   考试名称（字典）
     * @param idArray    添加的classId序列
     * @return ==0 为执行不成功
     */
    @RequestMapping("/examAdd.do")
    public int saveExam(String subject_id, String year, String semester, String examName, @RequestParam(value = "idList[]", required = false) String[] idArray) {
        List<String> idList = Arrays.asList(idArray); //把id数组转换为id集合
        int flag = scoreService.initScore(subject_id, year, semester, examName, idList);
        return flag;
    }

    /**
     * 得到对应班级是否有某个时间的考试
     *
     * @param subjectId 科目id（字典）
     * @param year      考试年
     * @param semester  考试学期
     * @param examName  考试名称（字典）
     * @param classId   班级ID
     * @return >0 代表有对应的考试计划 ==0 即代表没有
     */
    @RequestMapping("/examExist.do")
    public int examExist(String subjectId, String year, String semester, String examName, String classId) {
        int flag = scoreService.isExist(subjectId, year, semester, examName, classId);
        return flag;
    }

    /**
     * json用的scoreAdd页面json方法
     *
     * @param examYear  考试年
     * @param semster   考试学期
     * @param bathch    考试名称（字典）
     * @param stdYear   毕业年
     * @param className 班级名称
     * @return 班级列表的json
     */
    @RequestMapping("/scoreAddUiJson.do")
    public List<ClassInfoVo> scoreAddUi(String examYear, String semster, String bathch, String stdYear, String className) {
        List<ClassInfoVo> classInfoVoList = classInfoService.listAddScoreClassInfoVo(examYear, semster, bathch, stdYear, className);
        return classInfoVoList;
    }

    /**
     * 在一个班中找对应姓名的学生
     * @param studentName 学生姓名（模糊查询）
     * @param classId 班级的ID
     * @return 一个StudentVo对象集合
     */
    @RequestMapping("/searchStudentFormClassByStudentName.do")
    public List<StudentVo> searchStudentFormClassByStudentName(String studentName, String classId) {
        List<StudentVo> studentVoList = studentService.listStudentVoByClassIdAndStudentName(studentName, classId);
        return studentVoList;
    }

    @RequestMapping("/submitScore.do")
    public int submitScore(@RequestParam("submitArray[]") String[] submitArray){
        List<Map<String, Object>> parmMapList = new ArrayList<>();
        for(String item : submitArray){
            Map<String, Object> parmMap = new HashMap<>();
            String[] kV = item.split("&bdm&");
            parmMap.put("scoreId", kV[0]);
            parmMap.put("achievement", kV[1]);
            parmMapList.add(parmMap);
        }
        int flag = scoreService.submitScore(parmMapList);
        return flag;
    }
}
