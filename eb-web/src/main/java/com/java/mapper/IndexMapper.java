package com.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface IndexMapper {

    @Select("SELECT * FROM web_menu WHERE menuType = #{menuType}")
    List<Map<String,Object>> selectMenus(@Param("menuType") String menuType);
}
