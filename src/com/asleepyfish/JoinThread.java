package com.asleepyfish;

/**
 * @Author: zhoujh42045
 * @Date: 2022/3/10 10:17
 * @Description: TODO
 */
public class JoinThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("join thread" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();
        for (int i = 0; i < 300; i++) {
            if (i == 200) {
                System.out.println("主线程停止。。。");
                thread.join();
            }
            System.out.println("main thread" + i);
        }
    }
}
