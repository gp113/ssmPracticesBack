package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.DeviceTypeMapper;
import com.java.pojo.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceTypeServiceImpl implements com.java.service.DeviceTypeService {

    @Autowired
    private DeviceTypeMapper deviceTypeMapper;

    /**
     * 查询所有设备类型
     *
     * @param pageNum
     * @param pageSize
     * @param queryInfo
     * @return
     */
    @Override
    public Map<String, Object> list(Integer pageNum, Integer pageSize, Map<String, Object> queryInfo) {
        Map<String, Object> resultMap = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);

        List<Map<String, Object>> list = deviceTypeMapper.list(queryInfo);
        PageInfo pageInfo = new PageInfo(list);

        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());

        return resultMap;
    }

    /**
     * 获取所有厂商
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> getVendorList() {
        return deviceTypeMapper.getVendorList();
    }

    /**
     * 获取所有规约
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> getTxgyList() {
        return deviceTypeMapper.getTxgyList();
    }

    /**
     * 新增设备型号
     *
     * @param deviceType
     * @return
     */
    @Override
    public int saveDeviceType(DeviceType deviceType) {
        Date date = new Date();
        deviceType.setCreatTime(date);
        return deviceTypeMapper.addDeviceType(deviceType);
    }

    /**
     * 获取设备型号信息
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getDeviceTypeById(Integer id) {
        return deviceTypeMapper.getDeviceTypeById(id);
    }

    /**
     * 查询设备类型信息以及关联的厂商信息
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getDeviceTypeDetail(Integer id) {
        return deviceTypeMapper.getDeviceTypeDetail(id);
    }

    /**
     * 修改设备型号信息
     *
     * @param deviceType
     * @return
     */
    @Override
    public int updateDeviceType(DeviceType deviceType) {
        return deviceTypeMapper.updateDeviceType(deviceType);
    }

    /**
     * 根据id删除设备型号
     *
     * @param idStr
     * @return
     */
    @Override
    public int deleteDeviceTypeById(String idStr) {
        idStr = idStr.substring(0, idStr.lastIndexOf(','));
        return deviceTypeMapper.deleteDeviceTypeById(idStr);
    }
}
