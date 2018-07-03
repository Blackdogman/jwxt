package com.jwxt.dao.system;

import com.jwxt.model.system.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUserLoginNameAndUserPwd(SysUser user);

    List<SysUser> selectByUserLoginName(String studentId);

    List<SysUser> listAllUser();
}