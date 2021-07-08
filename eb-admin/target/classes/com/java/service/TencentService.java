package com.java.service;

import com.java.pojo.TencentCloudServer;

import java.util.List;
import java.util.Map;

public interface TencentService {

    /**
     * 查询云服务器，并分页显示
     *
     * @return
     */
    Map<String, Object> findAllCloud(Integer startIndex, Integer pageSize);

    /**
     * 添加云服务器
     *
     * @param cloudInfo
     * @return
     */
    boolean saveCloud(Map<String, Object> cloudInfo);

    /**
     * 根据id获取云服务器信息
     *
     * @param cloudID
     * @return
     */
    Map<String, Object> findCloudInfo(Integer cloudID);

    /**
     * 根据id更新云服务器信息
     *
     * @param cloudInfo
     * @return
     */
    boolean modifyCloudInfo(Map<String, Object> cloudInfo);

    /**
     * 根据idStr删除云服务器信息
     *
     * @param idStr
     * @return
     */
    boolean removeCloud(String idStr);

    /**
     * 根据条查询云服务器，没有条件时查询所有数据
     *
     * @param searchType
     * @param searchValue
     * @return
     */
    Map<String, Object> findCloudsBySearch(String searchType, String searchValue, Integer page, Integer rows);

    Map<String, Object> list(TencentCloudServer tencentCloudServer, int pageNum, int pagrSize);

    List<Map<String, Object>> getTypeList();

    List<Map<String, Object>> getHangYeTypeList();

    boolean saveCloudData(TencentCloudServer tencentCloudServer);

    boolean deleteCloud(String idStr);
}
