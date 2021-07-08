package com.java.service;

import java.util.List;
import java.util.Map;

public interface IndexService {
    List<Map<String,Object>> findMenus(String menuType);
}
