package com.imooc.weather;

import java.util.Random;

/**
 * 天气类，用户温度和湿度数据的存放和读取
 */
public class Weather {
    private int temperature;//温度
    private int humidity;//湿度
    boolean flag = false;//用于判断是生成还是读取天气信息

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    //生成天气的方法
    public synchronized void generate() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.temperature = new Random().nextInt(40);
        this.humidity = new Random().nextInt(100);
        System.out.println("生成天气数据" + this.toString());
        flag = true;
        this.notifyAll();
    }

    //读取天气数据的方法
    public synchronized void read() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("读取天气数据" + this.toString());
        flag = false;
        this.notifyAll();
    }

    @Override
    public String toString() {
        return "[" +
                "温度：" + temperature +
                "，湿度：" + humidity +
                "]";
    }
}
