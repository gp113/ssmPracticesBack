package com.java.service.impl;

import cn.hutool.core.util.StrUtil;
import com.java.mapper.TencentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TencentServiceImpl implements com.java.service.TencentService {

    @Autowired
    private TencentMapper tencentMapper;

    /**
     * 查询云服务器，并分页显示
     *
     * @return
     */
    @Override
    public Map<String, Object> findAllCloud(Integer page, Integer rows) {

        Map<String, Object> map = new HashMap<>();
        Date nowDate = new Date();
        Date endDate;
        String dateStr = "";
        Long nowTimeInMillis;
        Long endTimeInMillis;
        Long betweenDays;

        //分页查询云服务器
        Integer startIndex = (page - 1) * rows;
        Integer pageSize = rows;
        List<Map<String, Object>> resultList = tencentMapper.selectAllClouds(startIndex, pageSize);
        //查询云服务器总数
        int total = tencentMapper.selectCloudsCount();

        //指定格式化的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < resultList.size(); i++) {
            dateStr = resultList.get(i).get("endTime").toString();
            try {
                endDate = sdf.parse(dateStr);
            } catch (ParseException e) {
                throw new RuntimeException("日期转化错误");
            }

            //获取相差的天数
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            nowTimeInMillis = calendar.getTimeInMillis();
            calendar.setTime(endDate);
            endTimeInMillis = calendar.getTimeInMillis();

            //比较剩余天数后存入resultMap中
            betweenDays = (endTimeInMillis - nowTimeInMillis) / (1000L * 3600L * 24L) + 1;
            resultList.get(i).put("hasDate", betweenDays);
        }

        //将云服务器查询结果List和云服务器总数存入mao中
        map.put("rows", resultList);
        map.put("total", total);

        return map;
    }

    /**
     * 添加云服务器
     *
     * @param cloudInfo
     * @return
     */
    @Override
    public boolean saveCloud(Map<String, Object> cloudInfo) {
        if (StrUtil.hasEmpty(cloudInfo.get("manager").toString())) {
            cloudInfo.put("manager", "-");
        }
        if (StrUtil.hasEmpty(cloudInfo.get("IPAddress").toString())) {
            cloudInfo.put("IPAddress", "-");
        }
        return tencentMapper.insertCloud(cloudInfo) > 0;
    }

    /**
     * 根据id获取云服务器信息
     *
     * @param cloudID
     * @return
     */
    @Override
    public Map<String, Object> findCloudInfo(Integer cloudID) {
        return tencentMapper.selectCloudInfo(cloudID);
    }

    /**
     * 根据id更新云服务器信息
     *
     * @param cloudInfo
     * @return
     */
    @Override
    public boolean modifyCloudInfo(Map<String, Object> cloudInfo) {
        return tencentMapper.updateCloudInfo(cloudInfo) > 0;
    }

    /**
     * 根据idStr删除云服务器信息
     *
     * @param idStr
     * @return
     */
    @Override
    public boolean removeCloud(String idStr) {
        idStr = idStr.substring(0, idStr.lastIndexOf(','));
        return tencentMapper.deleteCloud(idStr) > 0;
    }

    /**
     * 根据条查询云服务器，没有条件时查询所有数据
     *
     * @param searchType
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> findCloudsBySearch(String searchType, String searchValue, Integer page, Integer rows) {

        Map<String, Object> map = new HashMap<>();
        Date nowDate = new Date();
        Date endDate;
        String dateStr = "";
        Long nowTimeInMillis;
        Long endTimeInMillis;
        Long betweenDays;

        //分页查询符合条件的云服务器
        Integer startIndex = (page - 1) * rows;
        Integer pageSize = rows;
        List<Map<String, Object>> resultList = tencentMapper.selectCloudsBySearch(searchType, searchValue, startIndex, pageSize);
        //查询符合条件的云服务器总数
        int total = tencentMapper.selectCloudsBySearchCount(searchType, searchValue);

        //指定格式化的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < resultList.size(); i++) {
            dateStr = resultList.get(i).get("endTime").toString();
            try {
                endDate = sdf.parse(dateStr);
            } catch (ParseException e) {
                throw new RuntimeException("日期转化错误");
            }

            //获取相差的天数
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            nowTimeInMillis = calendar.getTimeInMillis();
            calendar.setTime(endDate);
            endTimeInMillis = calendar.getTimeInMillis();

            //比较剩余天数后存入resultMap中
            betweenDays = (endTimeInMillis - nowTimeInMillis) / (1000L * 3600L * 24L) + 1;
            resultList.get(i).put("hasDate", betweenDays);
        }

        //将云服务器查询结果List和云服务器总数存入mao中
        map.put("rows", resultList);
        map.put("total", total);

        return map;
    }
}
