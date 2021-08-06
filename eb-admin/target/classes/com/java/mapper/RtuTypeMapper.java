package com.java.mapper;

import com.java.pojo.RtuType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RtuTypeMapper {

    List<Map<String, Object>> list(Map<String, Object> queryInfo);

    int addRtuType(RtuType rtuType);

    Map<String,Object> getRtuTypeById (@Param("id") Integer id);

    Map<String,Object> getRtuTypeDetail (@Param("id") Integer id);

    int updateRtuTypeById(RtuType rtuType);

    int deleteRtuTypeById(@Param("idStr") String idStr);
}
