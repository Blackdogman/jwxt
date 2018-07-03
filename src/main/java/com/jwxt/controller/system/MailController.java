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
     * @param model
     * @return
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
     * @param sysMail 邮件对象
     * @param session HttpSession用来取当前登录的用户
     * @return
     */
    @RequestMapping("/mailSend.do")
    public String mailSend(SysMail sysMail, HttpSession session) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        if(sysMail.getMailId() != null && sysMail.getMailId() != ""){
            sysMail.setFlag("1");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            int flag = sysMailService.sendMailUpdate(sysMail);
        }else {
            sysMail.setMailId(PrimaryKeyUtil.getPrimaryKey());
            sysMail.setFlag("1");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            int flag = sysMailService.sendMail(sysMail);
        }
        return "redirect:/mailController/mailSendHistoryUi.do";
    }

    /**
     * 存入草稿箱
     * @param sysMail 邮件对象
     * @param session HttpSession用来取当前登录的用户
     * @return
     */
    @RequestMapping("/saveDraft.do")
    @ResponseBody
    public String saveDraft(SysMail sysMail, HttpSession session, Model model){
        SysUser user = (SysUser) session.getAttribute("loginUser");
        System.out.println(sysMail.getMailId());
        if(sysMail.getMailId() != "" && sysMail.getMailId() != null){
            System.out.println("id不为空");
            sysMail.setFlag("0");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            int flag = sysMailService.saveDraftUpdate(sysMail);
        }else {
            System.out.println("id为空");
            sysMail.setMailId(PrimaryKeyUtil.getPrimaryKey());
            sysMail.setFlag("0");
            sysMail.setFromUserId(user.getUserId());
            sysMail.setCreateTime(new Date());
            int flag = sysMailService.saveDraft(sysMail);
        }
        return sysMail.getMailId();
    }

    /**
     * 删除邮件（变更邮件状态为3，进入垃圾箱未从数据库删除）
     * @param mailId 对应的邮件ID
     * @return
     */
    @RequestMapping("/deleteMail.do")
    public String deleteMail(String mailId){
        int flag = sysMailService.deleteMail(mailId);
        return null;
    }

    /**
     * 发件箱页面准备ui
     * @param session HttpSession取当前登录用户
     * @param model
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/mailSendHistoryUi.do", produces = "application/json;charset=utf-8")
    public String mailSendHistoryUi(HttpSession session, Model model,
                                    @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByFromUserId(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    /**
     * 收件箱准备ui
     * @param session HttpSession取当前登录用户
     * @param model
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/mailMyBox.do", produces = "application/json;charset=utf-8")
    public String mailMyBox(HttpSession session, Model model,
                            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByToUserId(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    /**
     * 垃圾箱准备ui
     * @param session HttpSession取当前登录用户
     * @param model
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/mailDeleteBox.do", produces = "application/json;charset=utf-8")
    public String mailDeleteBox(HttpSession session, Model model,
                                @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByToUserIdDeleteBox(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }

    /**
     * 草稿箱准备ui
     * @param session HttpSession取当前登录用户
     * @param model
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/mailDraftBox.do", produces = "application/json;charset=utf-8")
    public String mailDraftBox(HttpSession session, Model model,
                               @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        PagedResult<SysMailVo> pageResult = sysMailService.listAllMailByFromUserIdDraftBox(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailListDraft";
    }

    /**
     * 通过Mail的ID得到对应的mail
     * @param mailId
     * @param model
     * @return
     */
    @RequestMapping("/mailDetails.do")
    public String mailDetails(String mailId, Model model){
        SysMailVo sysMail = sysMailService.selectSysMailByMailId(mailId);
        model.addAttribute("sysMail", sysMail);
        return "view/frame/mail/mailDetails";
    }
}
