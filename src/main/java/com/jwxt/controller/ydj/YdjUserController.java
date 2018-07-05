package com.jwxt.controller.ydj;

import com.jwxt.model.ydj.YdjUser;
import com.jwxt.service.ydj.YdjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userController")
public class YdjUserController {
    @Autowired
    private YdjUserService userService;

    @RequestMapping("/update.do")
    public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                         YdjUser user) {
        System.err.println(user);

        return "view/frame/login";

    }
}
