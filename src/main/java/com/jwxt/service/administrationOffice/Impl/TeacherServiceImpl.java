package com.jwxt.service.administrationOffice.Impl;

import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.jwxt.dao.system.SysUserMapper;
import com.jwxt.dao.system.TeacherMapper;
import com.jwxt.model.system.SysUser;
import com.jwxt.model.system.Teacher;
import com.jwxt.model.system.TeacherVo;
import com.jwxt.service.administrationOffice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int addTeacher(Teacher teacher) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(PrimaryKeyUtil.getPrimaryKey());
        sysUser.setUserLoginName(teacher.getTeacherId());
        sysUser.setUserLoginPwd("123");
        sysUser.setUserCharactor("2");
        sysUser.setUserCreateTime(new Date());
        int flag1 = teacherMapper.insertSelective(teacher);
        int flag2 = sysUserMapper.insertSelective(sysUser);
        int flag = -1;
        if (flag1 > 0 && flag2 > 0) {
            flag = 1;
        }
        return flag;
    }

    @Override
    public PagedResult<TeacherVo> listAllTeacher(Integer pageNumber, Integer pageSize, TeacherVo teacherVo) {
        PageHelper.startPage(pageNumber, pageSize);
        List<TeacherVo> userList = teacherMapper.listAllTeacher(teacherVo);
        return PageBeanUtil.toPagedResult(userList);
    }

    @Override
    public int deleteTeacherByTeacherId(String teacherId) {
        return teacherMapper.deleteTeacherByTeacherId(teacherId);
    }
}
