package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.RtuTypeMapper;
import com.java.pojo.RtuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RtuTypeServiceImpl implements com.java.service.RtuTypeService {

    @Autowired
    private RtuTypeMapper rtuTypeMapper;

    /**
     * 获取所有rtu型号
     *
     * @param queryInfo
     * @return
     */
    @Override
    public Map<String, Object> list(Map<String, Object> queryInfo) {
        Map<String, Object> resultMap = new HashMap<>();
        String strTemp = "";

        List<Map<String, Object>> list = rtuTypeMapper.list(queryInfo);

        for (int i = 0; i < list.size(); i++) {
            strTemp = list.get(i).get("createTime").toString();
            strTemp = strTemp.substring(0, strTemp.lastIndexOf('.'));
            list.get(i).put("createTime", strTemp);
        }

        resultMap.put("data", list);
        resultMap.put("total", list.size());

        return resultMap;
    }

    /**
     * 添加RTU型号
     *
     * @param rtuType
     * @return
     */
    @Override
    public int saveRtuype(RtuType rtuType) {
        Date date = new Date();
        rtuType.setCreateTime(date);
        return rtuTypeMapper.addRtuType(rtuType);
    }

    /**
     * 根据id查询RTU型号信息
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getRtuTypeById(Integer id) {
        return rtuTypeMapper.getRtuTypeById(id);
    }

    /**
     * 查询RTU类型信息以及关联的厂商信息
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getRtuTypeDetail(Integer id) {
        Map<String, Object> resultMap = rtuTypeMapper.getRtuTypeDetail(id);
        String temp = resultMap.get("createTime").toString();
        temp = temp.substring(0, temp.lastIndexOf('.'));
        resultMap.put("createTime",temp);

        return resultMap;
    }

    /**
     * 根据id修改RTU型号信息
     *
     * @param rtuType
     * @return
     */
    @Override
    public int updateRtuTypeById(RtuType rtuType) {
        Date date = new Date();
        rtuType.setCreateTime(date);
        return rtuTypeMapper.updateRtuTypeById(rtuType);
    }

    /**
     * 根据id删除RTU型号
     *
     * @param idStr
     * @return
     */
    @Override
    public int deleteRtuTypeById(String idStr) {
        idStr = idStr.substring(0, idStr.lastIndexOf(','));
        return rtuTypeMapper.deleteRtuTypeById(idStr);
    }
}
