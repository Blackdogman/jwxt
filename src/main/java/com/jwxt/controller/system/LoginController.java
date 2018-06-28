package com.jwxt.controller.system;

import com.framework.controller.BaseController;
import com.jwxt.model.system.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {

    @RequestMapping("/login.do")
    public String login(SysUser user, Model model, HttpSession session){
        SysUser reUser = loginService.login(user);
        if(reUser == null){
            model.addAttribute("loginError", "用户名或者密码有误，请检查");
            return "view/frame/login";
        }else {
            session.setAttribute("loginUser", reUser);
            return "view/frame/index";
        }
    }
}
