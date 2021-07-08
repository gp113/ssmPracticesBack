package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.VendorMapper;
import com.java.pojo.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendorServiceImpl implements com.java.service.VendorService {

    @Autowired
    private VendorMapper vendorMapper;

    /**
     * 获取所有厂商信息
     *
     * @param vendor
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> list(Vendor vendor, Integer pageNum, Integer pageSize) {
        Map<String, Object> resultMap = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> vendorList = vendorMapper.list(vendor);
        PageInfo pageInfo = new PageInfo(vendorList);

        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());

        return resultMap;
    }

    /**
     * 根据厂商id查询厂商以及关联设备型号信息
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> selectById(int id) {
        return vendorMapper.selectById(id);
    }

    /**
     * 根据厂商id查询关联设备型号
     *
     * @param pageNum
     * @param pageSize
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> selectDeviceTypeById(Integer pageNum, Integer pageSize, int id) {
        Map<String, Object> resultMap = new HashMap<>();

        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = vendorMapper.selectDeviceTypeById(id);
        PageInfo pageInfo = new PageInfo(list);

        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());
        return resultMap;
    }

    /**
     * 添加厂商
     *
     * @param vendor
     * @return
     */
    @Override
    public int saveVendor(Vendor vendor) {
        Long id = vendor.getId();
        if (id != null) {
            return vendorMapper.updateVendor(vendor);
        } else {
            return vendorMapper.addVendor(vendor);
        }
    }

    /**
     * 根据id删除厂商
     *
     * @param idStr
     * @return
     */
    @Override
    public int deleteVendors(String idStr) {
        idStr = idStr.substring(0, idStr.lastIndexOf(','));
        return vendorMapper.deleteVendors(idStr);
    }
}
