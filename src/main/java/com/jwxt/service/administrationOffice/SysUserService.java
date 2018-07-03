package com.jwxt.service.administrationOffice;

import com.jwxt.model.system.SysUser;

import java.util.List;

public interface SysUserService {
    int userExist(String loginName);

    List<SysUser> listAllUser();
}
