package com.asleepyfish;

/**
 * @Author: zhoujh42045
 * @Date: 2022/3/10 10:12
 * @Description: TODO
 */
public class YieldThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始运行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "结束运行");
    }

    public static void main(String[] args) {
        YieldThread yieldThread = new YieldThread();
        new Thread(yieldThread, "A").start();
        new Thread(yieldThread, "B").start();
    }
}
