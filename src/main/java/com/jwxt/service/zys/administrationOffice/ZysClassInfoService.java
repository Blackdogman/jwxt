package com.jwxt.service.zys.administrationOffice;

import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.zys.administrationOffice.ZysClassInfo;
import com.jwxt.model.zys.administrationOffice.ZysClassInfoVo;

import java.util.List;

public interface ZysClassInfoService {

	PagedResult<ZysClassInfoVo> getAllByPage(Integer pageNumber, Integer pageSize, List<Integer> statusList);
	
	int addClass(ZysClassInfo classInfo);

	int setClassStatusToFalse(ZysClassInfo classInfo);

	ZysClassInfo queryClassInfoById(String id);

	int updateClassInfoByClassInfo(ZysClassInfo classInfo);

	int distributeStudent(String id, List<String> studentIdList);

	int cleanStudentByClassId(String id);

	List<ZysClassInfo> queryClassInfoByGraduateYear(int year);

}
