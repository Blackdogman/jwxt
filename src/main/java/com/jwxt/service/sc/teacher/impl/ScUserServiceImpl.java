package com.jwxt.service.sc.teacher.impl;

import com.jwxt.dao.sc.ScUserMapper;
import com.jwxt.model.sc.ScUser;
import com.jwxt.service.sc.teacher.ScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScUserServiceImpl implements ScUserService {

@Autowired	
private ScUserMapper userMapper;
	
	@Override
	public List<ScUser> selectPrimary() {
		// TODO Auto-generated method stub
		return userMapper.selectPrimary();
	}
	@Override
	public String seletTidbyname(String userLoginName) {
		// TODO Auto-generated method stub
		System.out.println("返回的值：" + userMapper.seletTidbyname(userLoginName));
		return userMapper.seletTidbyname(userLoginName);
	}
	@Override
	public ScUser selectByPrimaryKeyAndStatus(String teacherId) {
		
		return userMapper.selectByPrimaryKeyAndStatus(teacherId);
	}
	@Override
	public void updateByPrimaryKeySelective(ScUser us) {
		userMapper.updateByPrimaryKeySelective(us);
		System.out.println("增加成功");
	}
	@Override
	public ScUser queryByUserId(String userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}
	
	
	

}
