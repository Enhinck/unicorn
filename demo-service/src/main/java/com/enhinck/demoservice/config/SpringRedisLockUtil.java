package com.enhinck.demoservice.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/5/21 7:25 PM
 */
@Component
@Slf4j
public class SpringRedisLockUtil {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public boolean lock(String name) {
        try {
            Boolean result = redisTemplate.opsForValue().setIfAbsent(name, name, 10, TimeUnit.SECONDS);
            if (result != null && result) {
                return true;
            }
        } catch (Throwable e) {
            log.error("{}", e);
        }
        return false;
    }

    public void unlock(String name) {
        redisTemplate.delete(name);
    }
}
