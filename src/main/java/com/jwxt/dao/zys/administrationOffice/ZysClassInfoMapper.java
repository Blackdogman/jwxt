package com.jwxt.dao.zys.administrationOffice;

import java.util.List;

import com.jwxt.model.administrationOffice.ClassInfo;
import com.jwxt.model.administrationOffice.ClassInfoVo;
import com.jwxt.model.zys.administrationOffice.ZysClassInfo;
import com.jwxt.model.zys.administrationOffice.ZysClassInfoVo;

public interface ZysClassInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZysClassInfo record);

    int insertSelective(ZysClassInfo record);

    ZysClassInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZysClassInfo record);

    int updateByPrimaryKey(ZysClassInfo record);

	List<ZysClassInfoVo> queryAllClassInfo();

	List<ZysClassInfoVo> queryClassInfoByStatus(List<Integer> statusList);

	List<ZysClassInfo> queryClassInfoByGraduateYear(int classGraduateYear);
}