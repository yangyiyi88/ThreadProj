package com.imooc.runnable;

/**
 * 线程创建第二种方法：实现Runnable接口创建线程，重写run()方法，run()方法代表线程要执行的任务
 * 为生么要实现Runnable接口？
 * -Java不支持多继承
 * -不打算重写Thread类的其他方法
 */
class Cat implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + "A cat");
        }
    }
}

class Dog implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + "A dog");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Thread t1 = new Thread(cat);
        t1.start();
        Dog dog = new Dog();
        Thread t2 = new Thread(dog);
        t2.start();
        for (int i = 1; i <= 3; i++) {
            System.out.println("main thread");
        }
    }
}
