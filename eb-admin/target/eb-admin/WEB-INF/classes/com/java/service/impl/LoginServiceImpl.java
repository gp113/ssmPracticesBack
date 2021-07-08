package com.java.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.java.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements com.java.service.LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 判断是否能登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        if (StrUtil.isNullOrUndefined(username) || StrUtil.isNullOrUndefined(password)) {
            return false;
        } else {
            password = SecureUtil.md5(password);
            int result = loginMapper.login(username, password);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
