package com.jwxt.service.zys.dictionary;


import com.jwxt.model.zys.dictionary.ZysDictionary;

import java.util.List;

public interface ZysDictionaryService {

	List<ZysDictionary> queryDictionaryByType(String type);

}
