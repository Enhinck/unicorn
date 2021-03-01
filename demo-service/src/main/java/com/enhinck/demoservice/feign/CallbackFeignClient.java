package com.enhinck.demoservice.feign;

import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 注册回调服务
 *
 * @author enhinck Generate auto created
 * @date 2020-09-02 14:50:27
 */
@FeignClient("demo-service2")
public interface CallbackFeignClient {

    /**
     * 测试回调
     *
     * @return
     */
    @ApiOperation("测试回调")
    @PostMapping("/rpc/callback/test")
    Boolean test(@RequestParam("ss") String ss);

}