package com.jwxt.service.administrationOffice.Impl;

import com.jwxt.dao.system.SysUserMapper;
import com.jwxt.model.system.SysUser;
import com.jwxt.service.administrationOffice.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int userExist(String loginName) {
        List<SysUser> sysUserList = sysUserMapper.selectByUserLoginName(loginName);
        int flag;
        if(sysUserList.size() > 0){
            flag = 1;
        }else {
            flag = 0;
        }
        return flag;
    }

    @Override
    public List<SysUser> listAllUser() {
        return sysUserMapper.listAllUser();
    }
}
