package temp.dao;

import temp.model.ClassInfo;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}