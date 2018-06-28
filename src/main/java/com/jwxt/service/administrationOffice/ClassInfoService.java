package com.jwxt.service.administrationOffice;

import java.util.List;

import com.framework.utils.pageUtil.PagedResult;
import com.jwxt.model.administrationOffice.ClassInfo;
import com.jwxt.model.administrationOffice.ClassInfoVo;

public interface ClassInfoService {

	PagedResult<ClassInfoVo> getAllByPage(Integer pageNumber, Integer pageSize, List<Integer> statusList);
	
	int addClass(ClassInfo classInfo);

	int setClassStatusToFalse(ClassInfo classInfo);

	ClassInfo queryClassInfoById(String id);

	int updateClassInfoByClassInfo(ClassInfo classInfo);

    List<ClassInfoVo> listClassInfoVoByYearAndName(ClassInfoVo classInfoVo);
}
