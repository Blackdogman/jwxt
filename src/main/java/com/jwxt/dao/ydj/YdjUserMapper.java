package com.jwxt.dao.ydj;

import com.jwxt.model.ydj.YdjUser;

public interface YdjUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(YdjUser record);

    int insertSelective(YdjUser record);

    YdjUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(YdjUser record);

    int updateByPrimaryKey(YdjUser record);

    YdjUser queryUserByLogiNameAndPassword(YdjUser user);
}