package com.jwxt.controller.sc.teacher;


import com.framework.utils.PrimaryKeyUtil;
import com.jwxt.model.sc.ScMenu;
import com.jwxt.model.sc.ScRole;
import com.jwxt.model.sc.ScUser;
import com.jwxt.model.sc.ScroleMenu;
import com.jwxt.model.system.SysUser;
import com.jwxt.service.sc.menu.ScMenuService;
import com.jwxt.service.sc.menu.ScRoleMenuService;
import com.jwxt.service.sc.menu.ScRoleService;
import com.jwxt.service.sc.menu.ScUserRoleService;
import com.jwxt.service.sc.teacher.ScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author suchen
 * @Copyright (C), 布朗先生
 * @Date:2018年6月29日
 */
@Controller
@RequestMapping("MenuController")
public class MenuController {
    @Autowired
    private ScUserService userService;
    @Autowired
    private ScMenuService menuService;
    @Autowired
    private ScRoleService roleService;
    @Autowired
    private ScRoleMenuService rolemenuService;
    @Autowired
    private ScUserRoleService userRoleService;
    private String roleId1;
    /**  */
    private static final long serialVersionUID = -1698407617030740584L;

    @RequestMapping("/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                       ScMenu menu, String userLoginName) {
        userLoginName = ((SysUser) (session.getAttribute("loginUser"))).getUserLoginName();
        //通过用户名拿到Id
        String userId = userService.seletTidbyname(userLoginName);
        String roleId = userRoleService.selectRoIdByUId(userId);
        List<ScMenu> menulist = menuService.queryAllMenu();
        model.addAttribute("roleid", roleId);
        model.addAttribute("menulist", menulist);
        return "view/sc/menu/menulist";
    }

    @RequestMapping("/addUI.do")
    public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                        ScMenu menu, String loginName) {

        List<ScMenu> menuList = menuService.queryAllMenu();
        model.addAttribute("menuList", menuList);

        return "view/sc/menu/menuadd";
    }

    @RequestMapping("/add.do")
    public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                      ScMenu menu, String pId) {
        menu.setMenuId(PrimaryKeyUtil.getPrimaryKey());
        menu.setCreateTime(new Date());
        int n = menuService.addMenuByMenu(menu);
        return "redirect:/MenuController/list.do";
    }

    @RequestMapping("/delete.do")
    public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                         ScMenu menu, String menuId) {
        // 准备数据【用户列表对象】
        int n = menuService.deleteMenuByMenuId(menuId);
        // 2、跳转页面
        return "redirect:/MenuController/list.do";
    }

    @RequestMapping("/updateUI.do")
    public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                           ScMenu menu, String menuId) {
        // a.第一份数据
        ScMenu m = menuService.queryMenuByMenuId(menuId);
        model.addAttribute("menu", m);
        // b.第二份数据
        List<ScMenu> menuList = menuService.queryAllMenu();
        model.addAttribute("menuList", menuList);
        // 2、跳转页面
        return "view/sc/menu/menuupdate";
    }

    @RequestMapping("/fpMenuUI.do")
    public String fpMenuUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                           ScUser user, ScRole role, ScMenu menu, String roleId) {
        // 准备数据【角色对象】
        ScRole r = roleService.queryRoleByRoleId(roleId);
        model.addAttribute("role", r);
        List<ScMenu> menuList = menuService.queryAllMenu();
        model.addAttribute("menuList", menuList);
        // 3.准备选中角色数据
        List<ScMenu> menuListXZList = menuService.queryAllMenuXZ(roleId);
        List<String> list = new ArrayList<String>();
        for (ScMenu mm : menuListXZList) {
            list.add(mm.getMenuId());
        }
        model.addAttribute("ids", list);


        return "view/sc/menu/fpMenu";
    }

    @RequestMapping("/fpMenu.do")
    public String fpMenu(Model model,
                         ScRole role, ScMenu menu, ScroleMenu roleMenu, String roleId, String[] menuIds) {
        // 1、收集数据
        roleMenu.setRoleId(roleId);
        // 首先看数据库里面有没有相同
        rolemenuService.deleteRoleMenuByRoleId(roleId);
        // 3.调用业务
        // 准备数据【用户列表对象】
        for (String mId : menuIds) {
            roleMenu.setRoleMenuId(PrimaryKeyUtil.getPrimaryKey());
            roleMenu.setMenuId(mId);
            int m = rolemenuService.addRoleMenuByRoleMenu(roleMenu);
        }
        // 2、跳转页面
        return "view/sc/menu/fpMenuSuccess";
    }


}
