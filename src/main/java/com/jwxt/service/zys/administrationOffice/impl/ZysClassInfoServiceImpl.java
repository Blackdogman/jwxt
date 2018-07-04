package com.jwxt.service.zys.administrationOffice.impl;

import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.jwxt.dao.zys.administrationOffice.ZysClassInfoMapper;
import com.jwxt.dao.zys.student.ZysStudentMapper;
import com.jwxt.model.zys.administrationOffice.ZysClassInfo;
import com.jwxt.model.zys.administrationOffice.ZysClassInfoVo;
import com.jwxt.service.zys.administrationOffice.ZysClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZysClassInfoServiceImpl implements ZysClassInfoService {
	@Autowired
	private ZysClassInfoMapper classInfoMapper;
	@Autowired
	private ZysStudentMapper studentMapper;

	@Override
	public PagedResult<ZysClassInfoVo> getAllByPage(Integer pageNumber, Integer pageSize, List<Integer> statusList) {
		// 1.调用分页插件
		PageHelper.startPage(pageNumber, pageSize);
		
		// 2.查询数据库，获取数据
		List<ZysClassInfoVo> classInfoList = classInfoMapper.queryClassInfoByStatus(statusList);
		return PageBeanUtil.toPagedResult(classInfoList);
	}

	@Override
	public int addClass(ZysClassInfo classInfo) {
		return classInfoMapper.insertSelective(classInfo);
	}

	@Override
	public int setClassStatusToFalse(ZysClassInfo classInfo) {
		//将班级状态设置为无效
		classInfo.setClassStatus(2);
		return classInfoMapper.updateByPrimaryKeySelective(classInfo);
	}

	@Override
	public ZysClassInfo queryClassInfoById(String id) {
		return classInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateClassInfoByClassInfo(ZysClassInfo classInfo) {
		return classInfoMapper.updateByPrimaryKeySelective(classInfo);
	}

	@Override
	public int distributeStudent(String id, List<String> studentIdList) {
		Map<String, Object> map2 = new HashMap<>();
		map2.put("list", studentIdList);
		map2.put("classId", id);
		return studentMapper.updateClassIdByClassIdAndStudentId(map2);
	}

	@Override
	public int cleanStudentByClassId(String id) {
		return studentMapper.removeStudentClassIdByClassId(id);
	}

	@Override
	public List<ZysClassInfo> queryClassInfoByGraduateYear(int year) {
		return classInfoMapper.queryClassInfoByGraduateYear(year);
	}

}
