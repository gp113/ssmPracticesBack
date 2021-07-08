package com.java.service;

import com.java.pojo.GuiYue;

import java.util.Map;

public interface GuiYueService {
    Map<String, Object> list(Integer pageNum, Integer pageSize, GuiYue guiYue);
}
