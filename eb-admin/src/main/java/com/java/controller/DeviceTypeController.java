package com.java.controller;

import com.java.pojo.DeviceType;
import com.java.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    private DeviceTypeService deviceTypeService;

    //    查询所有设备型号信息
    @RequestMapping("/list")
    public Map<String, Object> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "999") Integer pageSize,
                                    String name,
                                    String vendorName) {
        Map<String, Object> queryInfo = new HashMap<>();
        queryInfo.put("name", name);
        queryInfo.put("vendorName", vendorName);
        return deviceTypeService.list(pageNum, pageSize, queryInfo);
    }

    //    获取所有厂商
    @RequestMapping("/getVendorList")
    public List<Map<String, Object>> getVendorList() {
        return deviceTypeService.getVendorList();
    }

    //    获取所有规约
    @RequestMapping("/getTxgyList")
    public List<Map<String, Object>> getTxgyList() {
        return deviceTypeService.getTxgyList();
    }

    //    保存设备型号
    @RequestMapping("/save")
    public int save(DeviceType deviceType) {
        return deviceTypeService.saveDeviceType(deviceType);
    }

    //    查询设备型号
    @RequestMapping("/getDeviceTypeById")
    public Map<String, Object> getDeviceTypeById(@RequestParam(value = "id") Integer id) {
        return deviceTypeService.getDeviceTypeById(id);
    }

    //    查询设备类型信息以及关联的厂商信息
    @RequestMapping("/getDeviceTypeDetail")
    public Map<String, Object> getDeviceTypeDetail(@RequestParam(value = "id") Integer id) {
        return deviceTypeService.getDeviceTypeDetail(id);
    }

    //    修改设备型号信息
    @RequestMapping("/updateDeviceType")
    public int updateDeviceType(DeviceType deviceType) {
        return deviceTypeService.updateDeviceType(deviceType);
    }

    //    删除设备型号
    @RequestMapping("/deleteDeviceTypeById")
    public int deleteDeviceTypeById(String idStr) {
        return deviceTypeService.deleteDeviceTypeById(idStr);
    }

}
