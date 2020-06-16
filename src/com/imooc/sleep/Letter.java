package com.imooc.sleep;

/**
 * 利用线程输出"a-z"的26个字母(横向输出)，要求每隔一秒钟输出一个字母
 */
public class Letter implements Runnable {
    //定义一个char类型的数组letter[]来存放26个字母
    char[] letter = new char[26];

    //创建无参构造方法对数组中元素进行循环赋值
    public Letter() {
        char n = 'a';
        for (int i = 0; i < letter.length; i++) {
            letter[i] = n++;
        }
    }

    //重写run()方法，再建立一个循环，循环中实现没隔一秒打印出一个字母
    @Override
    public void run() {
        for (int i = 0; i < 26; i++) {
            System.out.print(letter[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//创建测试类，创建Letter类的对象，再通过Letter类的对象创建线程类的对象，然后启动线程
class TestLetter {
    public static void main(String[] args) {
        Letter letter = new Letter();
        Thread t = new Thread(letter);
        t.start();
    }
}
