package com.jwxt.controller.ydj;


import com.jwxt.model.system.SysUser;
import com.jwxt.model.ydj.YdjStudentMessage;
import com.jwxt.model.ydj.YdjUser;
import com.jwxt.service.ydj.YdjStudentService;
import com.jwxt.service.ydj.YdjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/studentController")
public class YdjStudentController{
	@Autowired
	private YdjStudentService studentService;
	@Autowired
	private YdjUserService userService;
	@RequestMapping("/student.do")
	public String student(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		SysUser user   = (SysUser) session.getAttribute("USER");
		System.err.println("有没有学生名字呢?："+user);
		String name = user.getUserLoginName();
		System.err.println("打印一下名字麻6666666: "+name );
		 List<YdjStudentMessage> studentMessage= studentService.queryStudentMessage(name);
		 System.err.println("学生信息打印出来吧："+studentMessage);
		model.addAttribute("studentMessage", studentMessage);
		return "view/ydj/student_message";
}
	@RequestMapping("/update.do")
	public String updatePassWord(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model,String oldUserLoginPwd,String newUserLoginPwd) {
		SysUser user   = (SysUser) session.getAttribute("USER");
		String userLoginPwd = user.getUserLoginPwd();
		String userLoginName = user.getUserLoginName();
//		判断旧密码是否正确
		if (!userLoginPwd.equals(oldUserLoginPwd)) {
			model.addAttribute("passWordError", "旧密码错误，请重新输入");
			System.err.println("旧密码与新密码不一致，重新输入");
			return "view/ydj/keyword_update";
		}else {
//			输入新密码，并且修改
			System.err.println("旧密码与新密码一致，开始改密码");
			System.err.println("新密码是什么呢？"+newUserLoginPwd);
			user.setUserLoginName(userLoginName);
			user.setUserLoginPwd(newUserLoginPwd);
			YdjUser u = new YdjUser();
			u.setUserLoginName(user.getUserLoginName());
			u.setUserLoginPwd(user.getUserLoginPwd());
			u.setUserCharactor(user.getUserCharactor());
			u.setUserCreateTime(user.getUserCreateTime());
			u.setUserId(user.getUserId());
			u.setUserStatus(user.getUserStatus());
			int n = userService.updateByPrimaryKeySelective(u);
			System.err.println("密码该成功了的时候n是个什么值呢："+n);
			return "view/frame/login";
		}
}
	@RequestMapping("/relogin.do")
	public String relogin(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model,String oldUserLoginPwd,String newUserLoginPwd) {
		return "view/frame/login";
	}	
}