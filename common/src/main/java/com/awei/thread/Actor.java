package com.awei.thread.base;

/**
 * @description:
 * @author: PENGLW
 * @date: 2020/12/16
 */
public class Actor extends Thread{

    @Override
    public void run(){
        System.out.println(111);

        int count = 0;
        boolean result = true;
        while (result){
            System.out.println(getName() + "---"+(++count));
            if (count ==100){
                result = false;
            }

            if (count%10 == 0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



        System.out.println(getName() + "2222222");
    }

    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("测试线程");

        actor.start();


        Thread ac = new Thread(new Actress(),"测试");
        ac.start();
    }
}

class Actress implements Runnable{

    @Override
    public void run() {
        System.out.println(111);

        int count = 0;
        boolean result = true;
        while (result){
            System.out.println(Thread.currentThread().getName() + "---"+(++count));
            if (count ==100){
                result = false;
            }

            if (count%10 == 0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(Thread.currentThread().getName() + "2222222");
    }
}
