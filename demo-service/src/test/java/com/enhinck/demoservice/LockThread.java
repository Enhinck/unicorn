package com.enhinck.demoservice;

import lombok.Data;

/**
 * 描述
 *
 * @author huenbin
 * @date 2/24/21 10:32 AM
 */
@Data
public class LockThread extends Thread {
    private String test;
    public LockThread() {
    }

    public LockThread(String test) {
        this.test = test;
    }

    @Override
    public void run() {
        HashMapStudy.test(test);
        HashMapStudy.test2(test);
        HashMapStudy.test3(test);
    }
}
