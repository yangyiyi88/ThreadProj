package com.imooc.weather;

/**
 * 读取天气线程类
 */
public class ReadWeather implements Runnable {
    Weather weather;

    public ReadWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void run() {
        //模拟读取100次天气数据，每次读取数据需要0.1秒时间
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            weather.read();
        }
    }
}
