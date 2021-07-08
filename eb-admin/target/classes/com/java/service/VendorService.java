package com.java.service;

import com.java.pojo.Vendor;

import java.util.List;
import java.util.Map;

public interface VendorService {
    Map<String, Object> list(Vendor vendor, Integer pageNum, Integer pageSize);

    Map<String, Object> selectById(int id);

    Map<String, Object> selectDeviceTypeById(Integer pageNum, Integer pageSize, int id);

    int saveVendor(Vendor vendor);

    int deleteVendors(String idStr);
}
