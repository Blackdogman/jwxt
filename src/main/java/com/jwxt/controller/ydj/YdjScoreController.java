package com.jwxt.controller.ydj;


import com.jwxt.model.ydj.YdjScoreStudent;
import com.jwxt.service.ydj.YdjStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/scoreController")
public class YdjScoreController {
@Autowired
private YdjStudentService studentService;
@RequestMapping("/score.do")
public String score(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
	String id =(String) session.getAttribute("STUDENTid");
	System.err.println("有没有学生学号呢?："+id);
	List<YdjScoreStudent> list= studentService.queryScoreById(id);
	System.err.println("有没有数据呢？："+list);
	model.addAttribute("scoreStudent", list);
	return "view/frame/student_score";
}
}