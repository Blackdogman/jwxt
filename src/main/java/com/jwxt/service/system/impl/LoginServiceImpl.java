package com.jwxt.service.system.impl;

import com.jwxt.dao.system.SysUserMapper;
import com.jwxt.model.system.SysUser;
import com.jwxt.service.system.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser user) {
        return sysUserMapper.selectByUserLoginNameAndUserPwd(user);
    }
}
