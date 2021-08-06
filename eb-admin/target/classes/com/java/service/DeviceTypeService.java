package com.java.service;

import com.java.pojo.DeviceType;

import java.util.List;
import java.util.Map;

public interface DeviceTypeService {
    Map<String, Object> list(Integer pageNum, Integer pageSize, Map<String, Object> queryInfo);

    List<Map<String, Object>> getVendorList();

    List<Map<String, Object>> getTxgyList();

    int saveDeviceType(DeviceType deviceType);

    Map<String, Object> getDeviceTypeById(Integer id);

    Map<String, Object> getDeviceTypeDetail(Integer id);

    int updateDeviceType(DeviceType deviceType);

    int deleteDeviceTypeById(String idStr);
}
