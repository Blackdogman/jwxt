package packageMapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import packageModel.AdministrationOffice;
/**
*  @author author
*/
public interface AdministrationOfficeBaseMapper {

    int insertAdministrationOffice(AdministrationOffice object);

    int updateAdministrationOffice(AdministrationOffice object);

    List<AdministrationOffice> queryAdministrationOffice(AdministrationOffice object);

    AdministrationOffice queryAdministrationOfficeLimit1(AdministrationOffice object);

}