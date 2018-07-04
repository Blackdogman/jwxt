package com.jwxt.dao.zys.administrationOffice;


import com.jwxt.model.zys.administrationOffice.ZysUser;

public interface ZysUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(ZysUser record);

    int insertSelective(ZysUser record);

    ZysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(ZysUser record);

    int updateByPrimaryKey(ZysUser record);
}