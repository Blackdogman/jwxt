package com.jwxt.service.administrationOffice.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.jwxt.dao.administrationOffice.ClassInfoMapper;
import com.jwxt.model.administrationOffice.ClassInfo;
import com.jwxt.model.administrationOffice.ClassInfoVo;
import com.jwxt.service.administrationOffice.ClassInfoService;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public PagedResult<ClassInfoVo> getAllByPage(Integer pageNumber, Integer pageSize, List<Integer> statusList) {
        // 1.调用分页插件
        PageHelper.startPage(pageNumber, pageSize);

        // 2.查询数据库，获取数据
        List<ClassInfoVo> classInfoList = classInfoMapper.queryClassInfoByStatus(statusList);
        return PageBeanUtil.toPagedResult(classInfoList);
    }

    @Override
    public int addClass(ClassInfo classInfo) {
        return classInfoMapper.insertSelective(classInfo);
    }

    @Override
    public int setClassStatusToFalse(ClassInfo classInfo) {
        //将班级状态设置为无效
        classInfo.setClassStatus(2);
        return classInfoMapper.updateByPrimaryKeySelective(classInfo);
    }

    @Override
    public ClassInfo queryClassInfoById(String id) {
        return classInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateClassInfoByClassInfo(ClassInfo classInfo) {
        return classInfoMapper.updateByPrimaryKeySelective(classInfo);
    }

    @Override
    public List<ClassInfoVo> listClassInfoVoByYearAndName(ClassInfoVo classInfoVo) {
        return classInfoMapper.listClassInfoVoByYearAndName(classInfoVo);
    }

    @Override
    public List<ClassInfoVo> listAddScoreClassInfoVo(String examYear, String semester, String bathch, String stdYear, String className) {
        Map<String, Object> parmMap = new HashMap<>();
        parmMap.put("score_year", examYear);
        parmMap.put("score_semester", semester);
        parmMap.put("score_bathch", bathch);
        parmMap.put("class_graduate_year", stdYear);
        parmMap.put("class_name", className);
        return classInfoMapper.listAddScoreClassInfoVo(parmMap);
    }
}
