package com.java.controller;

import com.java.service.TencentService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tencent")
public class TencentController {

    @Autowired
    private TencentService tencentService;

    /**
     * 查询云服务器，并分页显示
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getAllClouds.do")
    @ResponseBody
    public Map<String, Object> getAllClouds(Integer page, Integer rows) {
        return tencentService.findAllCloud(page, rows);
    }

    /**
     * 添加云服务器
     *
     * @param hangYeType
     * @param cloudName
     * @param manager
     * @param IPAddress
     * @param endDate
     * @param cloudType
     * @return
     */
    @RequestMapping("/addCloud.do")
    @ResponseBody
    public boolean addCloud(int hangYeType, String cloudName, String manager, String IPAddress, String endDate, int cloudType) {
        Map<String, Object> map = new HashMap<>();
        map.put("hangYeType", hangYeType);
        map.put("cloudName", cloudName);
        map.put("manager", manager);
        map.put("IPAddress", IPAddress);
        map.put("endDate", endDate);
        map.put("cloudType", cloudType);

        return tencentService.saveCloud(map);
    }

    /**
     * 根据id获取云服务器信息
     *
     * @param cloudID
     * @return
     */
    @RequestMapping("/getCloudInfo.do")
    @ResponseBody
    public Map<String, Object> getCloudInfo(Integer cloudID) {
        return tencentService.findCloudInfo(cloudID);
    }

    /**
     * 根据id更新云服务器信息
     *
     * @param hangYeType
     * @param name
     * @param manager
     * @param IPAddress
     * @param endTime
     * @param type
     * @return
     */
    @RequestMapping("updateCloudInfo.do")
    @ResponseBody
    public boolean updateCloudInfo(Integer id, Integer hangYeType, String name, String manager, String IPAddress, String endTime, Integer type) {
        Map<String, Object> cloudInfo = new HashMap<>();
        cloudInfo.put("id", id);
        cloudInfo.put("hangYeType", hangYeType);
        cloudInfo.put("name", name);
        cloudInfo.put("manager", manager);
        cloudInfo.put("IPAddress", IPAddress);
        cloudInfo.put("endTime", endTime);
        cloudInfo.put("type", type);
        return tencentService.modifyCloudInfo(cloudInfo);
    }

    /**
     * 根据idStr删除云服务器信息
     *
     * @param idStr
     * @return
     */
    @RequestMapping("/deleteCloud.do")
    @ResponseBody
    public boolean deleteCloud(String idStr) {
        return tencentService.removeCloud(idStr);
    }

    /**
     * 根据条查询云服务器，没有条件时查询所有数据
     *
     * @param searchType
     * @param searchValue
     * @return
     */
    @RequestMapping("/getCloudsBySearch.do")
    @ResponseBody
    public Map<String, Object> getCloudsBySearch(String searchType, String searchValue,Integer page, Integer rows) {
        return tencentService.findCloudsBySearch(searchType, searchValue, page, rows);
    }
}
