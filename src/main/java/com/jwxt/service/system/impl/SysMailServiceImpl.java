package com.jwxt.service.system.impl;

import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.jwxt.dao.system.SysMailMapper;
import com.jwxt.model.system.SysMail;
import com.jwxt.model.system.SysMailVo;
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
    public PagedResult<SysMailVo> listAllMailByFromUserId(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);

        List<SysMailVo> sysMailList = sysMailMapper.listAllMailVoByFromUserId(userId);
        return PageBeanUtil.toPagedResult(sysMailList);
    }

    @Override
    public PagedResult<SysMailVo> listAllMailByToUserId(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysMailVo> sysMailList = sysMailMapper.listAllMailByToUserId(userId);
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
    public PagedResult<SysMailVo> listAllMailByToUserIdDeleteBox(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysMailVo> sysMailList = sysMailMapper.listAllMailByToUserIdDeleteBox(userId);
        return PageBeanUtil.toPagedResult(sysMailList);
    }

    @Override
    public PagedResult<SysMailVo> listAllMailByFromUserIdDraftBox(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysMailVo> sysMailList = sysMailMapper.listAllMailByFromUserIdDraftBox(userId);
        return PageBeanUtil.toPagedResult(sysMailList);
    }

    @Override
    public SysMailVo selectSysMailByMailId(String mailId) {
        return sysMailMapper.selectByPrimaryKeyVo(mailId);
    }

    @Override
    public int saveDraftUpdate(SysMail sysMail) {
        return sysMailMapper.updateByPrimaryKeySelective(sysMail);
    }

    @Override
    public int sendMailUpdate(SysMail sysMail) {
        return sysMailMapper.updateByPrimaryKeySelective(sysMail);
    }
}
