package com.enhinck.demoservice.controller;

import com.enhinck.demoservice.service.CallbackFeignClient;
import com.enhinck.demoservice.service.DemoService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/21/21 11:12 AM
 */
@RestController
public class TestDemoRpcController implements CallbackFeignClient {

    @Resource
    DemoService demoService;
    @Override
   // @GlobalTransactional
    public Boolean test(String ss) {
        demoService.saveDemo(ss);
        return true;
    }
}
