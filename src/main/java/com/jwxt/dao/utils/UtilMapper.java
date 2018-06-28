package com.jwxt.dao.utils;

import java.util.List;
import java.util.Map;

public interface UtilMapper {
    List<Map<String, String>> listDictionaryNameByType(String type);
}
