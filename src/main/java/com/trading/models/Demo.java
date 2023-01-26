package com.trading.models;

import java.util.ArrayList;
import java.util.List;

/**
 *  Модель демонстрационной платформы
 */

public class Demo {
    private static Demo demo;
    private double startPrice;
    private double currentPrice;
    private final List<Double> prises  = new ArrayList<>();

    private Demo() {
    }

    public static Demo getInstance() {
        if (demo == null) {
            demo = new Demo();
        }
        return demo;
    }

    public double getStartPrice() {
        return startPrice;
    }
    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public List<Double> getPrises() {
        return prises;
    }
}
