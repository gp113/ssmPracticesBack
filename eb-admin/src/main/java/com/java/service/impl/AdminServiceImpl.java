package com.java.service.impl;

import cn.hutool.core.util.StrUtil;
import com.java.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements com.java.service.AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 根据username和parentId查询菜单
     *
     * @param username
     * @param parentId
     * @return
     */
    @Override
    public List<Map<String, Object>> findMenu(String username, Long parentId) {
        return adminMapper.selectMenu(username, parentId);
    }

    /**
     * 查询菜单，并分页
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public Map<String, Object> findWebMenu(Integer page, Integer rows) {
        Map<String, Object> resultMap = new HashMap<>();
        Integer startIndex = (page - 1) * rows;
        Integer pageSize = page * rows;
        //调用dao层获取分页后的数据
        List<Map<String, Object>> hxMenu = adminMapper.selectWebMenu(startIndex, pageSize);
        //调用dao层获取web_menu表中的总记录数
        int count = adminMapper.selectWebMenuCount();
        resultMap.put("rows", hxMenu);
        resultMap.put("total", count);

        return resultMap;
    }

    /**
     * 添加横向菜单
     *
     * @param hxMenuName
     * @param hxMenuUrl
     * @return
     */
    @Override
    public boolean addHxMenu(String hxMenuName, String hxMenuUrl) {
        return adminMapper.insertHxMenu(hxMenuName, hxMenuUrl) > 0;
    }

    /**
     * 根据id修改横向菜单信息
     *
     * @param id
     * @param hxMenuName
     * @param hxMenuUrl
     * @return
     */
    @Override
    public boolean modify(Long id, String hxMenuName, String hxMenuUrl) {
        if (StrUtil.isNullOrUndefined(id.toString()) || StrUtil.isNullOrUndefined(hxMenuName) || StrUtil.isNullOrUndefined(hxMenuUrl)) {
            return false;
        } else {
            return adminMapper.updateHxMenu(id, hxMenuName, hxMenuUrl) > 0;
        }
    }

    /**
     * 根据id删除横向菜单信息
     *
     * @param idStr
     * @return
     */
    @Override
    public boolean removeHxMenu(String idStr) {
        if (StrUtil.isNullOrUndefined(idStr)) {
            return false;
        } else {
            idStr = idStr.substring(0, idStr.lastIndexOf(","));
            return adminMapper.deleteHxMenu(idStr) > 0;
        }
    }
}
