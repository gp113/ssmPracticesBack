package com.java.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface AdminMapper {

    /**
     * 根据username和parentId查询菜单
     *
     * @param username
     * @param parentId
     * @return
     */
    List<Map<String, Object>> selectMenu(@Param("username") String username, @Param("parentId") Long parentId);

    /**
     * 查询菜单，并分页
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM web_menu LIMIT #{startIndex} , #{pageSize}")
    List<Map<String, Object>> selectWebMenu(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    /**
     * 查询菜单总数
     *
     * @return
     */
    @Select("SELECT count(*) FROM web_menu")
    int selectWebMenuCount();

    /**
     * 添加横向菜单
     *
     * @return
     */
    @Insert("insert web_menu value (null,#{hxMenuName},#{hxMenuUrl},'1',now())")
    int insertHxMenu(@Param("hxMenuName") String hxMenuName, @Param("hxMenuUrl") String hxMenuUrl);

    /**
     * 根据id修改横向菜单信息
     *
     * @param id
     * @param hxMenuName
     * @param hxMenuUrl
     * @return
     */
    @Update("update web_menu set title = #{hxMenuName} , url = #{hxMenuUrl} where id = #{id}")
    int updateHxMenu(@Param("id") Long id, @Param("hxMenuName") String hxMenuName, @Param("hxMenuUrl") String hxMenuUrl);

    /**
     * 根据id删除横向菜单信息
     *
     * @param idStr
     * @return
     */
    @Delete("delete  from web_menu where id in (${idStr})")
    int deleteHxMenu(@Param("idStr") String idStr);
}
