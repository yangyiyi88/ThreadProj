package com.imooc.thread;

/**
 * 线程创建第一种方法：通过继承Thread类的方式创建线程,重写run()方法，run()方法代表线程要执行的任务
 */
class PrintThead extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + "打印机正在打印" + i);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        PrintThead pt = new PrintThead();
        pt.start();
    }
}
