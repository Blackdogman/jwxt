package com.jwxt.model.system;

import java.util.Date;

public class SysMailVo {
    private String mailId;

    private String fromUserName;

    private String fromUserId;

    private String toUserName;

    private String toUserId;

    private String mailSubject;

    private Date createTime;

    private String flag;

    private String mailContent;

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    @Override
    public String toString() {
        return "SysMailVo{" +
                "mailId='" + mailId + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", mailSubject='" + mailSubject + '\'' +
                ", createTime=" + createTime +
                ", flag='" + flag + '\'' +
                ", mailContent='" + mailContent + '\'' +
                '}';
    }
}