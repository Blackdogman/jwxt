package com.jwxt.controller.system;

import com.jwxt.model.system.SysUser;
import com.jwxt.service.system.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login.do")
    public String login(SysUser user, Model model, HttpSession session){
        SysUser reUser = loginService.login(user);
        if(reUser == null){
            model.addAttribute("loginError", "用户名或者密码有误，请检查");
            Map<String, String> testMap = new HashMap<>();
            testMap.put("1-性别", "男");
            testMap.put("2-性别", "女");
            model.addAttribute("testMap", testMap);
            List<String> keyList = new ArrayList<>();
            keyList.add("1");
            keyList.add("2");
            keyList.add("1");
            keyList.add("1");
            keyList.add("2");
            model.addAttribute("testList", keyList);
            return "view/frame/login";
        }else {
            session.setAttribute("loginUser", reUser);
            return "view/frame/index";
        }
    }
}
