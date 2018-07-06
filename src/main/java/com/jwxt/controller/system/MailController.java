package com.jwxt.controller.system;

import com.framework.controller.BaseController;
import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.system.SysMail;
import com.jwxt.model.system.SysMailVo;
import com.jwxt.model.system.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mailController")
public class MailController extends BaseController {
    /**
     * 发件页面
     */
    @RequestMapping("/mailSendUi.do")
    public String mailSendUi(Model model, String mailId) {
        List<SysUser> userList = sysUserService.listAllUser();
        model.addAttribute("userList", userList);
        SysMailVo sysMail = sysMailService.selectSysMailByMailId(mailId);
        model.addAttribute("sysMail", sysMail);
        return "view/frame/mail/mailSend";
    }

    /**
     * 发送邮件
     *
     * @param sysMail 邮件对象
     * @param session HttpSession用来取当前登录的用户
     */
    @RequestMapping("/mailSend.do")
    public String mailSend(SysMail sysMail, HttpSession session) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        int flag;
        if (sysMail.getMailId() != null && "".equals(sysMail.getMailId())) {
            sysMail.setFlag("1");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            flag = sysMailService.sendMailUpdate(sysMail);
        } else {
            sysMail.setMailId(PrimaryKeyUtil.getPrimaryKey());
            sysMail.setFlag("1");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            flag = sysMailService.sendMail(sysMail);
        }
        if (flag > 0) {
            return "redirect:/mailController/mailSendHistoryUi.do";
        } else {
            return "redirect:/mailController/mailSendUi.do?mailId=" + sysMail.getMailId();
        }
    }

    /**
     * 存入草稿箱
     *
     * @param sysMail 邮件对象
     * @param session HttpSession用来取当前登录的用户
     */
    @RequestMapping("/saveDraft.do")
    @ResponseBody
    public String saveDraft(SysMail sysMail, HttpSession session) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        if ("".equals(sysMail.getMailId()) && sysMail.getMailId() != null) {
            sysMail.setFlag("0");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            sysMailService.saveDraftUpdate(sysMail);
        } else {
            sysMail.setMailId(PrimaryKeyUtil.getPrimaryKey());
            sysMail.setFlag("0");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            sysMailService.saveDraft(sysMail);
        }
        return sysMail.getMailId();
    }

    /**
     * 删除邮件（变更邮件状态为3，进入垃圾箱未从数据库删除）
     *
     * @param mailId 对应的邮件ID
     */
    @RequestMapping("/deleteMail.do")
    public String deleteMail(String mailId) {
        sysMailService.deleteMail(mailId);
        return "redirect:/mailController/mailMyBox.do";
    }

    /**
     * 发件箱页面准备ui
     *
     * @param session HttpSession取当前登录用户
     */
    @RequestMapping(value = "/mailSendHistoryUi.do", produces = "application/json;charset=utf-8")
    public String mailSendHistoryUi(HttpSession session, Model model,
                                    @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByFromUserId(user.getUserId(), pageNumber, pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    /**
     * 收件箱准备ui
     *
     * @param session HttpSession取当前登录用户
     */
    @RequestMapping(value = "/mailMyBox.do", produces = "application/json;charset=utf-8")
    public String mailMyBox(HttpSession session, Model model,
                            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByToUserId(user.getUserId(), pageNumber, pageSize);
        model.addAttribute("pageResult", pageResult);
        model.addAttribute("mailBoxType", 1);
        return "view/frame/mail/mailList";
    }

    /**
     * 垃圾箱准备ui
     *
     * @param session HttpSession取当前登录用户
     */
    @RequestMapping(value = "/mailDeleteBox.do", produces = "application/json;charset=utf-8")
    public String mailDeleteBox(HttpSession session, Model model,
                                @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByToUserIdDeleteBox(user.getUserId(), pageNumber, pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    /**
     * 草稿箱准备ui
     *
     * @param session HttpSession取当前登录用户
     */
    @RequestMapping(value = "/mailDraftBox.do", produces = "application/json;charset=utf-8")
    public String mailDraftBox(HttpSession session, Model model,
                               @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByFromUserIdDraftBox(user.getUserId(), pageNumber, pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailListDraft";
    }

    /**
     * 通过Mail的ID得到对应的mail
     *
     * @param mailId 邮件ID
     */
    @RequestMapping("/mailDetails.do")
    public String mailDetails(String mailId, Model model) {
        SysMailVo sysMail = sysMailService.selectSysMailByMailId(mailId);
        model.addAttribute("sysMail", sysMail);
        return "view/frame/mail/mailDetails";
    }
}
