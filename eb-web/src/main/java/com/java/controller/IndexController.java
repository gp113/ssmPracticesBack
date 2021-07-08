package com.java.controller;

import com.java.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/web")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/getHxMenus.do")
    @ResponseBody
    public List<Map<String,Object>> getHxMenus(){
        return indexService.findMenus("1");
    }
}
