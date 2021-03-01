package com.enhinck.demoservice.service.impl;

import com.enhinck.demoservice.mapper.DictionaryMapper;
import com.enhinck.demoservice.model.domain.DictionaryDO;
import com.enhinck.demoservice.service.DemoService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

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
    DictionaryMapper dictionaryMapper;

    @Override
    public String saveDemo(String ss) {
        log.info("service2开始执行");
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            System.out.println("feign 获得分布式事务xid："+xid);
        }
        try {
            DictionaryDO dictionaryDO = new DictionaryDO();
            dictionaryDO.setLabel(ss);
            dictionaryDO.setValue(ss);
            dictionaryDO.setType(ss);
            dictionaryMapper.insert(dictionaryDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("service2执行完毕");
        return ss;
       // throw new RuntimeException("111");
    }
}
