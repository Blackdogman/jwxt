package com.jwxt.controller.ydj;

import com.jwxt.model.ydj.YdjClassInfo;
import com.jwxt.model.ydj.YdjStudent;
import com.jwxt.model.ydj.YdjUser;
import com.jwxt.service.ydj.YdjClassInfoService;
import com.jwxt.service.ydj.YdjStudentService;
import com.jwxt.service.ydj.YdjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginController")
public class YdjLoginController {
    /**  */

    @Autowired
    private YdjUserService userService;
    //	@Autowired
//	private YdjMenuService menuService;
    @Autowired
    private YdjStudentService studentService;
    @Autowired
    private YdjClassInfoService classInfoService;

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                        YdjUser user) {
        // 1.收集数据
        // 3.调用相关业务
        System.out.println("前台传入" + user);
        YdjUser u = userService.queryUserByLogiNameAndPassword(user);
        System.out.println("+++////++++////+++/////++" + u);
        if (u != null) {
            model.addAttribute("loginSuccess", "登录成功");
            session.setAttribute("USER", u);

            YdjStudent s = studentService.queryStudentByuserLoginName(user.getUserLoginName());
            String id = s.getStudentId();
            System.out.println("学生表中的班级ID：" + s);
            session.setAttribute("STUDENTid", id);
            session.setAttribute("CLASSID", s);
            YdjClassInfo c = classInfoService.queryClassById(s.getStudentClassId());
//				YdjClassInfo c = classInfoService.queryClassById(s.getStudentClassId());
            System.out.println("班级表中的班级名字：" + c);
            model.addAttribute("classId", "所属班级");
            session.setAttribute("CLA", c);


            ///////////////////
//				List<Menu> menuSelectedList = menuService.queryAllMenuXZByUserId(u.getUserId());
//				model.addAttribute("menuSelectedList", menuSelectedList);
//				for (Menu menu2 : menuSelectedList) {
//					System.out.println("+++++++++++++++++++++++" + menu2);
//				}
            ////////////////////

            return "view/frame/main";
        } else {
            model.addAttribute("loginError", "用户名或密码错误");
            // 2.跳转页面
            return "view/frame/login";
        }
    }

    //	@RequestMapping("/queryAnthortySon.do")
    //	public String queryAnthortySon(HttpServletRequest request, HttpServletResponse response, HttpSession session,
    //			Model model, YdjUser user, Menu menu, String menuId) {
    //		YdjUser u = (YdjUser) session.getAttribute("USER");
    //		// 把用户信息保存到session
    //		session.setAttribute("USER", u);
    //		if (u != null) {
    //			model.addAttribute("loginSuccess", "登录成功！");
    //
    //			List<Menu> menuSelectedListSon = menuService.queryMenuSelectedSonByMenuId(menuId);
    //			for (Menu menu2 : menuSelectedListSon) {
    //				System.out.println("===========================-----" + menu2);
    //			}
    //			model.addAttribute("menuSelectedListSon", menuSelectedListSon);
    //
    //			////////////////////
    //			List<Menu> menuSelectedList = menuService.queryAllMenuXZByUserId(u.getUserId());
    //			model.addAttribute("menuSelectedList", menuSelectedList);
    //			////////////////////
    //
    //			return "frame/main";
    //		} else {
    //			model.addAttribute("loginError", "用户名或密码错误，请重新输入！");
    //			return "main/login";
    //		}
    //
    //	}
}
