package com.awei.thread.base;

/**
 * @description:
 * @author: PENGLW
 * @date: 2020/12/16
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始了...");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "执行中。。。。。。");
        }
        System.out.println(Thread.currentThread().getName() + "结束了...！");
    }
}
