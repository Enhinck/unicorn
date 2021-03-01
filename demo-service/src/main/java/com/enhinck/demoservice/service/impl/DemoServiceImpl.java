package com.enhinck.demoservice.service.impl;

import com.enhinck.demoservice.feign.CallbackFeignClient;
import com.enhinck.demoservice.mapper.MenuMapper;
import com.enhinck.demoservice.model.domain.MenuDO;
import com.enhinck.demoservice.service.DemoService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/20/21 7:41 PM
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Resource
    CallbackFeignClient callbackFeignClient;

    @Resource
    MenuMapper menuMapper;
    @Override
    @Transactional
    @GlobalTransactional
    public String saveDemo(String ss) {

        log.info("service1开始执行");


        callbackFeignClient.test(ss);

        MenuDO menuDO = new MenuDO();
        menuDO.setName(ss);
        menuMapper.insert(menuDO);
        log.info("service2结束执行");

        //throw new RuntimeException("222");
        return "成功";
    }
}
