package com.jwxt.utils.Impl;

import com.jwxt.dao.utils.UtilMapper;
import com.jwxt.utils.DictionaryTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DictionaryToolsImpl implements DictionaryTools {
    @Autowired
    private UtilMapper utilMapper;

    @Override
    public List<Map<String, String>> listDictionaryNameByType(String type) {
        return utilMapper.listDictionaryNameByType(type);
    }
}
