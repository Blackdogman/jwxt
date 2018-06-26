package temp.dao;

import temp.model.AdministrationOffice;

public interface AdministrationOfficeMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdministrationOffice record);

    int insertSelective(AdministrationOffice record);

    AdministrationOffice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdministrationOffice record);

    int updateByPrimaryKey(AdministrationOffice record);
}