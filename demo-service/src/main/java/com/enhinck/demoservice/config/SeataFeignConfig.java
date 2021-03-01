package com.enhinck.demoservice.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/21/21 4:44 PM
 */
@Configuration
@Slf4j
public class SeataFeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            log.info("feign传递分布式事务xid：{}", xid);
            requestTemplate.header(RootContext.KEY_XID, xid);
        }
    }
}
