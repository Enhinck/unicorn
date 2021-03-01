package com.enhinck.demoservice.controller;

import com.enhinck.demoservice.config.RedissonLockUtil;
import com.enhinck.demoservice.config.SpringRedisLockUtil;
import com.enhinck.demoservice.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/5/21 6:43 PM
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    SpringRedisLockUtil redisUtil;
    @Autowired
    RedissonLockUtil redissonLockUtil;

    @Resource
    DemoService demoService;
    @GetMapping("/test")
    public String test() {
        return "ok";
    }


    @GetMapping("/lock")
    public Boolean test(@RequestParam("name") String name) {
        return redisUtil.lock(name);
    }

    @GetMapping("/unlock")
    public Boolean unlock(@RequestParam("name") String name) {
        redisUtil.unlock(name);
        return true;
    }


    @GetMapping("/redlock")
    public Boolean redlock(@RequestParam("name") String name) {
        RedissonRedLock redissonRedLock = redissonLockUtil.getRedLock(name);
        log.info("获得红锁");
        boolean isLock = false;
        try {
            isLock = redissonRedLock.tryLock(15,10, TimeUnit.SECONDS);
           if (isLock){
               log.info("开始锁定");
               Thread.sleep(5000);
               log.info("业务执行完毕");
               return true;
           }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (isLock){
                redissonRedLock.unlock();
                log.info("释放锁");
            }
        }

        return false;
    }

    @GetMapping("/rlock")
    public Boolean rlock(@RequestParam("name") String name) {
        RLock redissonRedLock = redissonLockUtil.getRLock(name);
        log.info("获得锁");
        try {
            redissonRedLock.lock(10, TimeUnit.SECONDS);
            log.info("开始锁定");
            Thread.sleep(5000);
            log.info("业务执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redissonRedLock.unlock();
            log.info("释放锁");
        }

        return true;
    }

    @GetMapping("/seata")
    public String seata(@RequestParam("name") String name) {



        return demoService.saveDemo(name);
    }
}
