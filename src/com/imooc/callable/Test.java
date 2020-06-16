package com.imooc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方法：实现callable接口，重写call()方法，call()作为线程的执行体，具有返回值，并且可以对异常进行声明和抛出；使用start()方法来启动线程
 */
//1.创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
class ThirdThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        //方法类型可以根据要返回值的类型进行确认
        String str = "多线程的第三种创建方式";
        return str;
    }
}

//测试方法
public class Test {
    public static void main(String[] args) {
        //2.创建Callable实现类的实例，使用FutureTast类来包装Callable对象，该FutureTast对象封装了该Callable对象的call()方法的返回值
        Callable<String> call = new ThirdThread();
        FutureTask<String> ft = new FutureTask<>(call);
        //3.使用FutureTast对象作为Thread对象的target创建并启动新线程
        Thread t3 = new Thread(ft);
        t3.start();
        //4.调用FutureTast对象的get()方法来获得子线程执行结束后的返回值
        //获取Call方法的返回值：先启动线程才可以获取到Call的返回值
        try {
            System.out.println(ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
