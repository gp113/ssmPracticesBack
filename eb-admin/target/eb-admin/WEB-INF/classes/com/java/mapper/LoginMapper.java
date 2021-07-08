package com.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {

    /**
     * 判断是否能登录
     *
     * @param username
     * @param password
     * @return
     */
    @Select("SELECT count(*) FROM admin_users WHERE username = #{username} AND password = #{password}")
    int login(@Param("username") String username, @Param("password") String password);
}
