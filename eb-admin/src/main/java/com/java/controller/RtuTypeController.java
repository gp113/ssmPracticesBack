package com.java.controller;

import com.java.pojo.RtuType;
import com.java.service.RtuTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rtuType")
public class RtuTypeController {

    @Autowired
    private RtuTypeService rtuTypeService;

    // 查询rtu型号信息
    @RequestMapping("/list")
    public Map<String, Object> listTest(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "999") Integer pageSize,
                                        String name,
                                        Integer guiyue,
                                        String vendorName) {
        Map<String, Object> queryInfo = new HashMap<>();
        queryInfo.put("name", name);
        queryInfo.put("guiyue", guiyue);
        queryInfo.put("vendorName", vendorName);
        queryInfo.put("pageNum", pageNum - 1);
        queryInfo.put("pageSize", pageSize);

        return rtuTypeService.list(queryInfo);
    }

    //添加RTU型号
    @RequestMapping("/save")
    public int save(RtuType rtuType) {
        return rtuTypeService.saveRtuype(rtuType);
    }

    //根据id查询RTU型号信息
    @RequestMapping("/getRtuTypeById")
    public Map<String, Object> getRtuTypeById(Integer id) {
        return rtuTypeService.getRtuTypeById(id);
    }

    //查询RTU类型信息以及关联的厂商信息
    @RequestMapping("/getRtuTypeDetail")
    public Map<String, Object> getRtuTypeDetail(Integer id) {
        return rtuTypeService.getRtuTypeDetail(id);
    }

    //根据id修改RTU型号信息
    @RequestMapping("/updateRtuTypeById")
    public int updateRtuTypeById(RtuType rtuType) {
        return rtuTypeService.updateRtuTypeById(rtuType);
    }

    //根据id删除RTU型号
    @RequestMapping("/deleteRtuTypeById")
    public int deleteRtuTypeById(String idStr){
        return rtuTypeService.deleteRtuTypeById(idStr);
    }
}
