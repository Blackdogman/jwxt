package com.jwxt.controller.ydj;

import com.jwxt.model.ydj.YdjStudent;
import com.jwxt.model.ydj.YdjStudentCourse;
import com.jwxt.service.ydj.YdjStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/courseController")
public class YdjCourseController{
	private static final long serialVersionUID = 7888923833723408051L;
	@Autowired
	private YdjStudentService studentService;
	String[][] arr = new String[7][7];
	List<YdjStudentCourse> list1 = new ArrayList<YdjStudentCourse>();

	// ArrayList arr = new ArrayList();
	@RequestMapping("/course.do")
	public String course(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		YdjStudentCourse studentCourse = null;
		YdjStudent st = (YdjStudent) (session.getAttribute("CLASSID"));
		System.err.println("班级编号：" + st.getStudentClassId());
		String n = st.getStudentClassId();
		list1 = studentService.queryCourseWeekPeriodByClassId(n);
		System.err.println("控制层中可以试一试吗？：" + list1);
		
		// // 强转，把String类型转为int类型
		for (int i = 0; i < list1.size(); i++) {
			studentCourse = list1.get(i);
			int studWeek =Integer.parseInt(studentCourse.getCourseWeekday());
			int studPeriod =Integer.parseInt(studentCourse.getCoursePeriod());
			arr[studPeriod-1][studWeek-1] = studentCourse.getCourseName();
		}
		model.addAttribute("course2", arr);
		return "view/frame/student_course";
	}

}