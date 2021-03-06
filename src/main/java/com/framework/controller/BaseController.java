package com.framework.controller;

import com.jwxt.service.administrationOffice.*;
import com.jwxt.service.system.LoginService;
import com.jwxt.service.system.SysMailService;
import com.jwxt.utils.DictionaryTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController extends HttpServlet {
	@Autowired
	protected LoginService loginService;
	@Autowired
	protected StudentService studentService;
	@Autowired
	protected TeacherService teacherService;
	@Autowired
	protected SysUserService sysUserService;
	@Autowired
	protected ClassInfoService classInfoService;
	@Autowired
	protected ScoreService scoreService;
	@Autowired
	protected SysMailService sysMailService;


	@Autowired
	protected DictionaryTools dictionaryTools;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3412511940987849417L;

	/**
	 * <p>
	 * 时间属性的编辑器
	 * </p>
	 * 
	 * @author zlf
	 * @Date 2017年6月4日
	 * @param servletRequestDataBinder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder servletRequestDataBinder) {
		servletRequestDataBinder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
