package com.java.mapper;

import com.java.pojo.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface DeviceTypeMapper {

    List<Map<String,Object>> list (Map<String,Object> queryInfo);

    List<Map<String,Object>> getVendorList();

    List<Map<String,Object>> getTxgyList();

    int addDeviceType(DeviceType deviceType);

    Map<String,Object> getDeviceTypeById(@Param("id") Integer id);

    Map<String,Object> getDeviceTypeDetail(@Param("id") Integer id);

    int updateDeviceType(DeviceType deviceType);

    int deleteDeviceTypeById (@Param("idStr") String idStr);

}
