package com.enhinck.demogateway.config.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/6/21 10:03 AM
 */
@Slf4j
public class Demo {


    public static void main(String[] args) {

        Demo demo = new Demo();

        demo.test("111",111, (s,l) -> invokeDemo().test(s,l));

    }

    public Object test(String s,Integer l, Invoke invoke) {
        log.info("{}", s);
        invoke.test(s,l);
        //return invoke.test(s,l);
        return null;
    }

    public static InvokeDemo invokeDemo() {
        InvokeDemo invokeDemo = new InvokeDemo();
        return invokeDemo;
    }
}
