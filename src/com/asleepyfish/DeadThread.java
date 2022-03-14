package com.asleepyfish;

/**
 * @Author: zhoujh42045
 * @Date: 2022/3/14 15:27
 * @Description: 死锁
 */
public class DeadThread {
    public static void main(String[] args) {
        Eat eat = new Eat(0);
        Eat eat1 = new Eat(1);
        new Thread(eat, "小明").start();
        new Thread(eat1, "小红").start();
    }
}

class Chopsticks {

}

class Plate {

}

class Eat implements Runnable {
    int choice;
    // static表示只有一份资源
    private static final Chopsticks chopsticks = new Chopsticks();
    private static final Plate plate = new Plate();

    public Eat(int choice) {
        this.choice = choice;
    }

    @Override
    public void run() {
        if (choice == 0) {
            synchronized (chopsticks) {
                System.out.println(Thread.currentThread().getName() + "拿到了筷子");
                // 都拿着对方的资源不放
                synchronized (plate) {
                    System.out.println(Thread.currentThread().getName() + "拿到了盘子");
                }
            }
        } else {
            synchronized (plate) {
                System.out.println(Thread.currentThread().getName() + "拿到了盘子");
                synchronized (chopsticks) {
                    System.out.println(Thread.currentThread().getName() + "拿到了筷子");
                }
            }
        }
    }
}
