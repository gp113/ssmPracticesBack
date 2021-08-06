package com.java.service;

import com.java.pojo.RtuType;

import java.util.Map;

public interface RtuTypeService {
    Map<String, Object> list(Map<String, Object> queryInfo);

    int saveRtuype(RtuType rtuType);

    Map<String, Object> getRtuTypeById(Integer id);

    Map<String, Object> getRtuTypeDetail(Integer id);

    int updateRtuTypeById(RtuType rtuType);

    int deleteRtuTypeById(String idStr);
}
