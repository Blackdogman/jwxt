package com.jwxt.controller.system;

import com.framework.controller.BaseController;
import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.system.SysMail;
import com.jwxt.model.system.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mailController")
public class MailController extends BaseController {
    @RequestMapping("/mailSendUi.do")
    public String mailSendUi(Model model) {
        List<SysUser> userList = sysUserService.listAllUser();
        model.addAttribute("userList", userList);
        return "view/frame/mail/mailSend";
    }

    @RequestMapping("/mailSend.do")
    public String mailSend(SysMail sysMail, HttpSession session) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysMail.setMailId(PrimaryKeyUtil.getPrimaryKey());
        sysMail.setFlag("1");
        sysMail.setFromUserId(user.getUserId());
        sysMail.setCreateTime(new Date());
        int flag = sysMailService.sendMail(sysMail);
        return "redirect:/mailController/mailSendHistoryUi.do";
    }

    @RequestMapping("/saveDraft")
    public String saveDraft(SysMail sysMail, HttpSession session){
        SysUser user = (SysUser) session.getAttribute("loginUser");
        sysMail.setMailId(PrimaryKeyUtil.getPrimaryKey());
        sysMail.setFlag("0");
        sysMail.setFromUserId(user.getUserId());
        sysMail.setCreateTime(new Date());
        int flag = sysMailService.saveDraft(sysMail);
        return null;
    }

    @RequestMapping("/deleteMail")
    public String deleteMail(String mailId){
        int flag = sysMailService.deleteMail(mailId);
        return null;
    }

    @RequestMapping(value = "/mailSendHistoryUi.do", produces = "application/json;charset=utf-8")
    public String mailSendHistoryUi(HttpSession session, Model model,
                                    @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMail> pageResult = sysMailService.listAllMailByFromUserId(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    @RequestMapping(value = "/mailMyBox.do", produces = "application/json;charset=utf-8")
    public String mailMyBox(HttpSession session, Model model,
                            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMail> pageResult = sysMailService.listAllMailByToUserId(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    @RequestMapping(value = "/mailDeleteBox.do", produces = "application/json;charset=utf-8")
    public String mailDeleteBox(HttpSession session, Model model,
                                @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMail> pageResult = sysMailService.listAllMailByToUserIdDeleteBox(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    @RequestMapping(value = "/mailDraftBox.do", produces = "application/json;charset=utf-8")
    public String mailDraftBox(HttpSession session, Model model,
                               @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMail> pageResult = sysMailService.listAllMailByFromUserIdDraftBox(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }
}
