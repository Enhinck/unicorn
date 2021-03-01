package com.enhinck.demoservice;

import lombok.Data;

/**
 * 描述
 *
 * @author huenbin
 * @date 2/24/21 10:32 AM
 */
@Data
public class LockThread2 extends Thread {
    private String test;
    public LockThread2() {
    }

    public LockThread2(String test) {
        this.test = test;
    }

    @Override
    public void run() {
        HashMapStudy.test2(test);
        HashMapStudy.test(test);
        HashMapStudy.test3(test);
    }
}
