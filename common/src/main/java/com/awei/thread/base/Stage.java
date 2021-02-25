package com.awei.thread.base;


/**
 * @description:
 * @author: PENGLW
 * @date: 2020/12/16
 */
public class Stage extends Thread {

    @Override
    public void run(){

        System.out.println("开始执行。。。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("------------------------------");

        TestRunnable test1 = new TestRunnable();
        TestRunnable test2 = new TestRunnable();

        //使用Runnable接口创建线程
        Thread test1Runble = new Thread(test1,"测试1");
        Thread test2Runble = new Thread(test2,"测试线程2");

        //启动线程，让军队开始作战
        test1Runble.start();
        test2Runble.start();

        try {
            //使当前线程睡眠
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("半路出现新的线程。。。。。。");

        Thread newThread = new TestThread();
        newThread.setName("新的线程！！！");

        //停止线程的方法
        test1.keepRunning = false;
        test2.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动新的线程
        newThread.start();

        //所有线程等待加入了.join()方法的线程执行完成
        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完毕。。。。。");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
