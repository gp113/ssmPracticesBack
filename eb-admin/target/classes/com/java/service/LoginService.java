package com.java.service;

public interface LoginService {

    /**
     * 判断是否能登录
     *
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);
}
