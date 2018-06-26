package com.jwxt.controller.system;

import com.jwxt.model.system.SysUser;
import com.jwxt.service.system.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login.do")
    public String login(SysUser user, Model model){
        System.out.println(user);
        SysUser reUser = loginService.login(user);
        if(reUser == null){
            model.addAttribute("loginError", "用户名或者密码有误，请检查");
            return "view/frame/login" ;
        }else {
            System.out.println(reUser);
        }
        return null;
    }
}
