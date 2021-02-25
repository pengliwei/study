package com.awei.thread.base;

/**
 * @description:
 * @author: PENGLW
 * @date: 2020/12/16
 */
public class TestRunnable implements Runnable{

    //volatile保证了线程可以正确的读取其他线程写入的值
    //可见性 ref JMM， happens-before原则
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"执行次数["+i+"]");
                //让出处理器时间，下次循环不确定是谁在执行
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName() + "结束了！");
    }
}
