package com.jwxt.service.system;

import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.system.SysMail;
import com.jwxt.model.system.SysMailVo;

public interface SysMailService {
    int sendMail(SysMail sysMail);

    PagedResult<SysMailVo> listAllMailByFromUserId(String userId, Integer pageNumber, Integer pageSize);

    PagedResult<SysMailVo> listAllMailByToUserId(String userId, Integer pageNumber, Integer pageSize);

    int saveDraft(SysMail sysMail);

    int deleteMail(String mailId);

    PagedResult<SysMailVo> listAllMailByToUserIdDeleteBox(String userId, Integer pageNumber, Integer pageSize);

    PagedResult<SysMailVo> listAllMailByFromUserIdDraftBox(String userId, Integer pageNumber, Integer pageSize);

    SysMailVo selectSysMailByMailId(String mailId);

    int saveDraftUpdate(SysMail sysMail);

    int sendMailUpdate(SysMail sysMail);
}
