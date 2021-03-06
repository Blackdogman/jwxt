package com.jwxt.dao.system;

import com.jwxt.model.system.SysMail;
import com.jwxt.model.system.SysMailVo;

import java.util.List;

public interface SysMailMapper {
    int deleteByPrimaryKey(String mailId);

    int insert(SysMail record);

    int insertSelective(SysMail record);

    SysMail selectByPrimaryKey(String mailId);

    int updateByPrimaryKeySelective(SysMail record);

    int updateByPrimaryKeyWithBLOBs(SysMail record);

    int updateByPrimaryKey(SysMail record);

    List<SysMail> listAllMailByFromUserId(String userId);

    List<SysMailVo> listAllMailVoByFromUserId(String userId);

    List<SysMailVo> listAllMailByToUserId(String userId);

    List<SysMailVo> listAllMailByToUserIdDeleteBox(String userId);

    List<SysMailVo> listAllMailByFromUserIdDraftBox(String userId);

    SysMailVo selectByPrimaryKeyVo(String mailId);
}