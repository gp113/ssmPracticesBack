package com.java.mapper;

import com.java.pojo.Vendor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VendorMapper {

    List<Map<String, Object>> list(Vendor vendor);

    Map<String, Object> selectById(@Param(value = "id") int id);

    List<Map<String,Object>> selectDeviceTypeById (@Param(value = "id") int id);

    int addVendor(Vendor vendor);

    int updateVendor(Vendor vendor);

    int deleteVendors(@Param("idStr") String idStr);
}
