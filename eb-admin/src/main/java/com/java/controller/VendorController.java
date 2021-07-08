package com.java.controller;

import com.java.pojo.Vendor;
import com.java.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    /**
     * 获取所有厂商信息
     *
     * @param vendor
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public Map<String, Object> list(Vendor vendor,
                                    @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "999") Integer pageSize) {
        return vendorService.list(vendor, pageNum, pageSize);
    }

    /**
     * 根据厂商id查询厂商以及关联设备型号信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    public Map<String, Object> selectById(int id) {
        return vendorService.selectById(id);
    }

    /**
     * 根据厂商id查询关联设备型号
     *
     * @param pageNum
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/selectDeviceTypeById")
    public Map<String, Object> selectDeviceTypeById(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "999") Integer pageSize,
                                                    int id) {
        return vendorService.selectDeviceTypeById(pageNum, pageSize, id);
    }

    /**
     * 保存厂商
     *
     * @param vendor
     * @return
     */
    @RequestMapping("/saveVendor")
    public int saveVendor(Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    /**
     * 根据id删除厂商
     * @param idStr
     * @return
     */
    @RequestMapping("/deleteVendors")
    public int deleteVendors(String idStr){
        return vendorService.deleteVendors(idStr);
    }
}
