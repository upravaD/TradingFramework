package com.trading.models.services;

import com.trading.models.Demo;
import java.util.Random;

public class DemoTrading {
    private Demo demo;

    public DemoTrading() {
        this.demo = Demo.getInstance();
        demo.setStartPrice(20_000);
    }

    public void initializePlatform() {

    }

    public void updatePrice() {
        int price = demo.getStartPrice();
        int random = new Random().nextInt(600);

        if(new Random().nextBoolean()) {
            price += random;
        }
        else {
            price -= random;
        }
        demo.setCurrentPrice(price);
    }

    public void stopPlatform() {

    }
}
