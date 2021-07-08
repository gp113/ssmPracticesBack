package com.java.service;

import java.util.List;
import java.util.Map;

public interface AdminService {
    /**
     * 根据username和parentId查询菜单
     *
     * @param username
     * @param padentId
     * @return
     */
    List<Map<String, Object>> findMenu(String username, Long padentId);

    /**
     * 查询菜单，并分页
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    Map<String, Object> findWebMenu(Integer startIndex, Integer pageSize);

    /**
     * 添加横向菜单
     *
     * @param hxMenuName
     * @param hxMenuUrl
     * @return
     */
    boolean addHxMenu(String hxMenuName, String hxMenuUrl);

    /**
     * 根据id修改横向菜单信息
     *
     * @param id
     * @param hxMenuName
     * @param hxMenuUrl
     * @return
     */
    boolean modify(Long id, String hxMenuName, String hxMenuUrl);

    /**
     * 根据id删除横向菜单信息
     *
     * @param idStr
     * @return
     */
    boolean removeHxMenu(String idStr);
}
