package com.jwxt.service.administrationOffice.Impl;

import com.framework.utils.PrimaryKeyUtil;
import com.jwxt.dao.system.StudentMapper;
import com.jwxt.dao.system.SysUserMapper;
import com.jwxt.model.system.Student;
import com.jwxt.model.system.SysUser;
import com.jwxt.service.administrationOffice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public int addStudent(Student student) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(PrimaryKeyUtil.getPrimaryKey());
        sysUser.setUserLoginName(student.getStudentId());
        sysUser.setUserLoginPwd("123");
        sysUser.setUserCharactor("1");
        sysUser.setUserCreateTime(new Date());
        int flag1 = studentMapper.insertSelective(student);
        int flag2 =sysUserMapper.insertSelective(sysUser);
        int flag = -1;
        if(flag1 > 0 && flag2 > 0){
            flag = 1;
        }
        return flag;
    }

    @Override
    public int userExist(String studentId) {
        List<SysUser> sysUserList = sysUserMapper.selectByUserLoginName(studentId);
        int flag = -1;
        if(sysUserList.size() > 0){
            flag = 1;
        }else {
            flag = 0;
        }
        return flag;
    }
}
