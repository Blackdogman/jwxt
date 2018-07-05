package com.jwxt.service.ydj.imp;

import com.jwxt.dao.ydj.YdjUserMapper;
import com.jwxt.model.ydj.YdjUser;
import com.jwxt.service.ydj.YdjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YdjUserServiceImp implements YdjUserService {
@Autowired
private YdjUserMapper userMapper;
	@Override
	public YdjUser queryUserByLogiNameAndPassword(YdjUser user) {
		return userMapper.queryUserByLogiNameAndPassword(user);
	}
	@Override
	public int updateByPrimaryKeySelective(YdjUser user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

}
