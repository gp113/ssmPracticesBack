package com.java.service.impl;

import com.java.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@CacheConfig(cacheNames = {"IndexServiceImpl_"})
@Service
public class IndexServiceImpl implements com.java.service.IndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Map<String, Object>> findMenus(String menuType) {
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            Object obj = valueOperations.get("hxMenu");
            if (obj == null) {
                List<Map<String, Object>> hxMenuList = indexMapper.selectMenus(menuType);
                valueOperations.set("hxMenu", hxMenuList);
                //设置失效时间
                redisTemplate.expire("hxMenu", 10, TimeUnit.SECONDS);
                return hxMenuList;
            }
            return (List<Map<String, Object>>) obj;
        } catch (Exception e) {
            System.out.println("IndexServiceImpl_findMenus...忘记开redis");
            return indexMapper.selectMenus(menuType);
        }
    }
}
