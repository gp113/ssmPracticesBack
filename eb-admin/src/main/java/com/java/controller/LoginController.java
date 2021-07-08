package com.java.controller;

import com.java.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login.do")
    public String login(String account, String password, HttpSession session) {
        session.setAttribute("username", account);
        boolean flag = loginService.login(account, password);
        if (flag) {
            return "index";
        } else {
            return "login";
        }
    }
    @RequestMapping("/loginTest.do")
    @ResponseBody
    public boolean loginTest(String username, String password) {
        return loginService.login(username, password);
    }

}
