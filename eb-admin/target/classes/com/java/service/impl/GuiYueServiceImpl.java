package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.GuiYueMapper;
import com.java.pojo.GuiYue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuiYueServiceImpl implements com.java.service.GuiYueService {

    @Autowired
    private GuiYueMapper guiYueMapper;

    /**
     * 获取所有规约信息
     *
     * @param pageNum
     * @param pageSize
     * @param guiYue
     * @return
     */
    @Override
    public Map<String, Object> list(Integer pageNum, Integer pageSize, GuiYue guiYue) {
        Map<String, Object> resultMap = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);

        List<Map<String, Object>> guiYueList = guiYueMapper.list(guiYue);
        PageInfo pageInfo = new PageInfo(guiYueList);

        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());
        return resultMap;
    }
}
