package com.jwxt.dao.system;

import com.jwxt.model.system.SysMail;

public interface SysMailMapper {
    int deleteByPrimaryKey(String mailId);

    int insert(SysMail record);

    int insertSelective(SysMail record);

    SysMail selectByPrimaryKey(String mailId);

    int updateByPrimaryKeySelective(SysMail record);

    int updateByPrimaryKeyWithBLOBs(SysMail record);

    int updateByPrimaryKey(SysMail record);
}