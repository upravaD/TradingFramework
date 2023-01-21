package com.trading.models;

/**
 *  Модель демонстрационной платформы
 */

public class Demo {
    private static Demo demo;
    private int startPrice;
    private int currentPrice;

    private Demo() {
    }

    public static Demo getInstance() {
        if (demo == null) {
            demo = new Demo();
        }
        return demo;
    }

    public int getStartPrice() {
        return startPrice;
    }
    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}
