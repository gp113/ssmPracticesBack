package com.java.controller;

import com.java.pojo.GuiYue;
import com.java.service.GuiYueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/guiyue")
public class GuiYueController {

    @Autowired
    private GuiYueService guiYueService;

    @RequestMapping("/list")
    public Map<String,Object> list (@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "999") Integer pageSize,
                                    GuiYue guiYue){
        return guiYueService.list(pageNum,pageSize,guiYue);
    }

}
