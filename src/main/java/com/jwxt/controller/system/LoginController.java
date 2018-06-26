package com.jwxt.controller.system;

import com.jwxt.model.system.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginController")
public class LoginController {
    @RequestMapping("/login.do")
    public String login(SysUser user, Model model){
        return null;
    }
}
