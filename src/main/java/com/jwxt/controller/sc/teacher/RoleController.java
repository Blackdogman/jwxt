package com.jwxt.controller.sc.teacher;

import com.framework.utils.PrimaryKeyUtil;
import com.jwxt.model.sc.ScRole;
import com.jwxt.model.sc.ScUser;
import com.jwxt.model.sc.ScUserRole;
import com.jwxt.model.system.SysUser;
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
@RequestMapping("RoleController")
public class RoleController {
    @Autowired
    private ScRoleService roleService;
    @Autowired
    private ScUserService userService;
    @Autowired
    private ScUserRoleService userRoleService;

    /**  */
    private static final long serialVersionUID = 1288068683339969435L;

    @RequestMapping("/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                       ScRole role, String loginName, String userLoginName) {
        userLoginName = ((SysUser) (session.getAttribute("loginUser"))).getUserLoginName();
        List<ScUser> a = userService.selectPrimary();
        model.addAttribute("userLoginName", userLoginName);
        List<ScRole> roleList = roleService.queryAllRole();
        model.addAttribute("roleList", roleList);

        return "view/sc/menu/rolelist";
    }

    @RequestMapping("/fpRoleUI.do")
    public String fpRoleUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                           ScUser user, ScRole role, String roleId, String userLoginName) {
        String userId = userService.seletTidbyname(userLoginName);
        // 3.调用业务
        // 准备数据【用户列表对象】
        ScUser u = userService.queryByUserId(userId);
        model.addAttribute("user", u);
        List<ScRole> roleList = roleService.queryAllRole();
        model.addAttribute("roleList", roleList);

        // 3.准备选中角色数据
        List<ScRole> roleListXZList = roleService.queryAllRoleXZ(userId);
        List<String> list = new ArrayList<String>();
        for (ScRole r : roleListXZList) {
            list.add(r.getRoleId());
        }
        model.addAttribute("ids", list);
        return "view/sc/menu/fpRole";
    }

    @RequestMapping("/fpRole.do")
    public String fpRole(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
                         ScUser user, ScRole role, ScUserRole userRole, String roleId, String userId, String[] roleIds) {
        // 1、收集数据
        userRole.setUserId(userId);

        // 首先看数据库里面有没有相同
        int n = userRoleService.deleteUserRoleByUserId(userId);
        // 3.调用业务
        // 准备数据【用户列表对象】
        for (String rId : roleIds) {
            userRole.setUserRoleId(PrimaryKeyUtil.getPrimaryKey());
            userRole.setRoleId(rId);
            int m = userRoleService.addUserRoleByUserRole(userRole);
        }

        // 2、跳转页面
        return "view/sc/menu/fpRoleSuccess";
    }
}
