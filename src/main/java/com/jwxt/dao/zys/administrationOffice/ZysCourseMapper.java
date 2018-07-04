package com.jwxt.dao.zys.administrationOffice;


import com.jwxt.model.zys.administrationOffice.ZysCourse;
import com.jwxt.model.zys.administrationOffice.ZysCourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZysCourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZysCourse record);

    int insertSelective(ZysCourse record);

    ZysCourse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZysCourse record);

    int updateByPrimaryKey(ZysCourse record);

	List<ZysCourseVo> queryCourseByParam(@Param("classId") String classId, @Param("courseYear") String courseYear, @Param("courseSemester") String courseSemester);

    ZysCourse selectCourseByParam(@Param("courseClassId") String courseClassId, @Param("courseYear") String courseYear, @Param("courseSemester") String courseSemester, @Param("coursePeriod") String coursePeriod);
}