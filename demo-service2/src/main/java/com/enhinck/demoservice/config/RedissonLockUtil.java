package com.enhinck.demoservice.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/19/21 1:53 PM
 */
@Component
@Slf4j
public class RedissonLockUtil {
    @Resource
    RedissonClient redissonClient1;
    @Resource
    RedissonClient redissonClient2;
    @Resource
    RedissonClient redissonClient3;

    public RedissonRedLock getRedLock(String lockKey) {
        RLock lock1 = redissonClient1.getLock(lockKey);
        RLock lock2 = redissonClient2.getLock(lockKey);
        RLock lock3 = redissonClient3.getLock(lockKey);
        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);


        return redLock;
    }

    public RLock getRLock(String lockKey) {
        RLock lock1 = redissonClient1.getLock(lockKey);

        return lock1;
    }

}
