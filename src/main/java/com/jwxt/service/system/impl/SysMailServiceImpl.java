package com.jwxt.service.system.impl;

import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.jwxt.dao.system.SysMailMapper;
import com.jwxt.model.system.SysMail;
import com.jwxt.service.system.SysMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMailServiceImpl implements SysMailService {
    @Autowired
    private SysMailMapper sysMailMapper;

    @Override
    public int sendMail(SysMail sysMail) {
        return sysMailMapper.insert(sysMail);
    }

    @Override
    public PagedResult<SysMail> listAllMailByFromUserId(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysMail> sysMailList = sysMailMapper.listAllMailByFromUserId(userId);
        return PageBeanUtil.toPagedResult(sysMailList);
    }

    @Override
    public PagedResult<SysMail> listAllMailByToUserId(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysMail> sysMailList = sysMailMapper.listAllMailByToUserId(userId);
        return PageBeanUtil.toPagedResult(sysMailList);
    }

    @Override
    public int saveDraft(SysMail sysMail) {
        return sysMailMapper.insertSelective(sysMail);
    }

    @Override
    public int deleteMail(String mailId) {
        SysMail sysMail = sysMailMapper.selectByPrimaryKey(mailId);
        sysMail.setFlag("3");
        return sysMailMapper.updateByPrimaryKeySelective(sysMail);
    }

    @Override
    public PagedResult<SysMail> listAllMailByToUserIdDeleteBox(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysMail> sysMailList = sysMailMapper.listAllMailByToUserIdDeleteBox(userId);
        return PageBeanUtil.toPagedResult(sysMailList);
    }

    @Override
    public PagedResult<SysMail> listAllMailByFromUserIdDraftBox(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysMail> sysMailList = sysMailMapper.listAllMailByFromUserIdDraftBox(userId);
        return PageBeanUtil.toPagedResult(sysMailList);
    }
}
