package com.dail.user.controller;

import com.dail.dto.CacheResult;
import com.dail.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: dailiang
 * @Date: 2018/12/26 16:05
 * @Description:
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private RedisClient redisClient;

    @GetMapping(value="/getKeyFromRedis/{key}")
    public String getKeyFromRedis(@PathVariable(name = "key") String key) {
        CacheResult<String> cacheResult = redisClient.get(key);
        return cacheResult.getData();
    }

    @GetMapping(value="/setkey/{key}/{value}")
    public String setkey(@PathVariable(name = "key") String key, @PathVariable(name = "value") String value) {
        return redisClient.set(key, value);
    }
}
