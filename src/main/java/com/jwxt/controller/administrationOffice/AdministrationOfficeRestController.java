package com.jwxt.controller.administrationOffice;

import com.framework.controller.BaseController;
import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.administrationOffice.ClassInfoVo;
import com.jwxt.model.system.Student;
import com.jwxt.model.system.StudentVo;
import com.jwxt.model.system.Teacher;
import com.jwxt.model.system.TeacherVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/administrationOfficeController")
public class AdministrationOfficeRestController extends BaseController {

    @RequestMapping("/examAddUiJson.do")
    public List<ClassInfoVo> examAddUiJson(String year, String className){
        ClassInfoVo classInfoVo = new ClassInfoVo();
        if(year != null && year != ""){
            classInfoVo.setClassGraduateYear(year);
        }
        if(className != null && className != ""){
            classInfoVo.setClassName(className);
        }
        List<ClassInfoVo> classInfoVoList = classInfoService.listClassInfoVoByYearAndName(classInfoVo);
        return classInfoVoList;
    }

    @RequestMapping("/saveExam.do")
    public void saveExam(String subject_id, String year, String semester, String examName,@RequestParam(value = "idList[]", required = false) String[] idArray){
        List<String> idList = Arrays.asList(idArray);
        System.out.println("subject_id: " + subject_id);
        System.out.println("year: " + year);
        System.out.println("semester: " + semester);
        System.out.println("examName: " + examName);
        System.out.println("idList: " + idList);

    }
}