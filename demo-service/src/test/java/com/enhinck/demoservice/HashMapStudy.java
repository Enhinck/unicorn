package com.enhinck.demoservice;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述
 *
 * @author huenbin
 * @date 2/23/21 1:57 PM
 */
public class HashMapStudy {

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;


    public static final Object obj = new Object();

    public static final Object obj2 = new Object();

    public static  void test(String name){
        System.out.println("test:"+name+"开始");
        try {
            synchronized (obj){
                synchronized (obj2){
                    Thread.sleep(100);
                }
            }
        }catch (Exception e){

        }

        System.out.println("test:"+name+"结束");
    }

    public static  void test2(String name){
        System.out.println("test2:"+name+"开始");
        try {
            synchronized (obj2){
                synchronized (obj){
                    Thread.sleep(100);
                }
            }
        }catch (Exception e){

        }


        System.out.println("test2:"+name+"结束");
    }

    public static void test3(String name){
        System.out.println("test3:"+name+"开始");
        try {
            synchronized (obj){
                synchronized (obj2){
                    Thread.sleep(100);
                }
            }
        }catch (Exception e){

        }

        System.out.println("test3:"+name+"结束");
    }


    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        LinkedHashMap linkedHashMap = new LinkedHashMap();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        test("111");

        for (int i = 1; i < 10; i++) {
            LockThread lockThread1 = new LockThread("线程"+i);
            lockThread1.start();
        }
        for (int i = 1; i < 10; i++) {
            LockThread2 lockThread1 = new LockThread2("2线程"+i);
            lockThread1.start();
        }





        Hashtable hashtable = new Hashtable();
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(i + "-" + ca(i));
//        }

        // System.out.println(1<<30);


        double x = 123.0;
        int y = 3;

        double r = weiYunsuan(x, y);


        double r2 = x / (Math.pow(2, y));

        System.out.println(r + "====" + r2);
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            int ran = random.nextInt();
            int n = (int) Math.pow(2, ran);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start + "ms");
        for (int i = 0; i < 1000_0000; i++) {
            int ran = random.nextInt();
            int n = 1 << ran;
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - end1 + "ms");
        System.out.println((int) Math.pow(2, 30));
        System.out.println(MAXIMUM_CAPACITY);
    }

    public static int ca(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int result = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

        return result;
    }


    public static double weiYunsuan(double x, int move) {
        int temp = (int) x * 1000_000;
        int result = temp >> move;
        return result / 1000_000.0;
    }


}
