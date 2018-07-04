package com.jwxt.controller.system;

import com.framework.controller.BaseController;
import com.jwxt.model.sc.ScMenu;
import com.jwxt.model.sc.ScUser;
import com.jwxt.model.system.SysUser;
import com.jwxt.service.sc.menu.ScMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {
    @Autowired
    private ScMenuService menuService;

    @RequestMapping("/login.do")
    public String login(SysUser user, Model model, HttpSession session){
        SysUser reUser = loginService.login(user);
        if(reUser == null){
            model.addAttribute("loginError", "用户名或者密码有误，请检查");
            return "view/frame/login";
        }else {
            session.setAttribute("loginUser", reUser);
            List<ScMenu> menuList = menuService.getUserMenu(reUser.getUserId());
            model.addAttribute("menuList", menuList);
            return "view/frame/index";
        }
    }

    @RequestMapping("/getKidMenuList.do")
    public void getKidMenuList(HttpServletResponse resp, HttpServletRequest request, HttpSession session, String menuId) {
        try {
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
            resp.setContentType("text/html; charset=utf-8;");
            String userId = ((SysUser) session.getAttribute("loginUser")).getUserId();
            List<ScMenu> menuList = menuService.listKidMenuByMenuIdAndUserId(userId, menuId);
            StringBuilder sb = new StringBuilder();
            for (ScMenu menu : menuList) {
                sb.append("<li>");
                sb.append("<a href=\""+ basePath + menu.getAnthortyUrl() + "\" target=\"right\">");
                sb.append("<span class=\"icon-caret-right\"></span>" + menu.getAnthortyName() + "");
                sb.append("</a>");
                sb.append("</li>");
            }
            resp.getWriter().print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
