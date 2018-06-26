package temp.dao;

import temp.model.Sys_User;

public interface Sys_UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Sys_User record);

    int insertSelective(Sys_User record);

    Sys_User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(Sys_User record);

    int updateByPrimaryKey(Sys_User record);
}