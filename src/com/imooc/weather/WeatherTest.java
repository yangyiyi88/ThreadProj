package com.imooc.weather;

/**
 * 测试类，模拟生成和读取数据的过程，要求实现生成一次，紧接着进行读取，不能出现不同步的情况
 */
public class WeatherTest {
    public static void main(String[] args) {
        Weather weather = new Weather();
        new Thread(new GenerateWeather(weather)).start();
        new Thread(new ReadWeather(weather)).start();
    }
}
