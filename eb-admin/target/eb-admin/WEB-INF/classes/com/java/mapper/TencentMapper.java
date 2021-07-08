package com.java.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface TencentMapper {

    /**
     * 查询云服务器，并分页
     *
     * @return
     */
    @Select("SELECT  * FROM tencent_cloud LIMIT #{startIndex},#{pageSize}")
    List<Map<String, Object>> selectAllClouds(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    /**
     * 查询云服务器总数
     *
     * @return
     */
    @Select("SELECT count(*) FROM tencent_cloud")
    int selectCloudsCount();

    /**
     * 添加云服务器
     *
     * @param cloudInfo
     * @return
     */
    @Insert("INSERT INTO tencent_cloud VALUE (NULL ,#{hangYeType},#{cloudName},#{manager},#{IPAddress},#{endDate},#{cloudType})")
    int insertCloud(Map<String, Object> cloudInfo);

    /**
     * 根据id获取云服务器信息
     *
     * @param cloudID
     * @return
     */
    @Select("SELECT  * FROM tencent_cloud WHERE id = #{cloudID}")
    Map<String, Object> selectCloudInfo(@Param("cloudID") Integer cloudID);

    /**
     * 根据id更新云服务器信息
     *
     * @param cloudInfo
     * @return
     */
    @Update("UPDATE tencent_cloud SET hangYeType = #{hangYeType} ,name = #{name} , manager = #{manager}, IPAddress = #{IPAddress}, endTime = #{endTime}, type = #{type} WHERE id = #{id}")
    int updateCloudInfo(Map<String, Object> cloudInfo);

    /**
     * 根据idStr删除云服务器信息
     *
     * @param idStr
     * @return
     */
    @Delete("DELETE FROM tencent_cloud WHERE id IN (${idStr})")
    int deleteCloud(@Param("idStr") String idStr);

    /**
     * 根据条查询云服务器，没有条件时查询所有数据
     *
     * @param searchType
     * @param searchValue
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> selectCloudsBySearch(@Param("searchType") String searchType, @Param("searchValue") String searchValue, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    /**
     * 根据条查询云服务器的总数，没有条件时查询所有数据的总数
     *
     * @param searchType
     * @param searchValue
     * @return
     */
    int selectCloudsBySearchCount(@Param("searchType") String searchType, @Param("searchValue") String searchValue);
}
