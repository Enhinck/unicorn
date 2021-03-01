package com.enhinck.demogateway.config.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/6/21 10:10 AM
 */
@Slf4j
public class InvokeDemo implements Invoke {

    public InvokeDemo(){
        log.info("InvokeDemo INIT");
    }
    @Override
    public Object test(String ss,Integer l) {
        log.info("XXXX：{}", ss);
        return null;
    }
}
