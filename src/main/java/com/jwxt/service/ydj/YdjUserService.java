package com.jwxt.service.ydj;

import com.jwxt.model.ydj.YdjUser;

public interface YdjUserService {

	YdjUser queryUserByLogiNameAndPassword(YdjUser user);

	int updateByPrimaryKeySelective(YdjUser user);

}
