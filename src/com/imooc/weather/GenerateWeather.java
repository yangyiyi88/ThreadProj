package com.imooc.weather;

/**
 * 生成天气线程类
 */
public class GenerateWeather implements Runnable {
    Weather weather;

    public GenerateWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void run() {
        //模拟生成100次天气数据，每次生成天气数据需要5秒时间
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            weather.generate();
        }
    }
}
