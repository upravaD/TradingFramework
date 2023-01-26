package com.trading.models.services;

import com.trading.models.Demo;
import com.trading.models.enums.OrderSide;
import com.trading.models.enums.PlatformManager;
import com.trading.models.enums.Symbol;

import java.time.LocalTime;
import java.util.Random;

public class DemoTrading {
    private final Demo demo;

    public DemoTrading() {
        this.demo = (Demo) PlatformManager.DEMO.getPlatform();
        demo.setStartPrice(20_000);
    }

    private void printStartPrice() {
        System.out.println("============================\n");
        System.out.println("Start Price = " + demo.getStartPrice() + " (" + Symbol.XBTUSD + ") ");
        System.out.println("\n============================");
    }

    private void printCurrentPrice() {
        System.out.println("Current Price = " + demo.getCurrentPrice() + " (" + Symbol.XBTUSD + ") { " + LocalTime.now() + " }");
        System.out.println("-------------------------------------------------------");
    }

    private void updatePrice() {
        double price = demo.getStartPrice();
        int random = new Random().nextInt(600);

        if (new Random().nextBoolean()) {
            price += random;
        } else {
            price -= random;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        demo.setCurrentPrice(price);
        demo.getPrises().add(price);
        printCurrentPrice();
    }

    public void startPlatform(int stopCount) {
        int startCount = 0;
        printStartPrice();

        while(startCount < stopCount) {
            updatePrice();


            if (Demo.getInstance().getCurrentPrice() < 19_800 && Demo.getInstance().getCurrentPrice() > 19_600){
                System.out.println(OrderSide.Buy + " 1");
            }
            if (Demo.getInstance().getCurrentPrice() < 19_600 && Demo.getInstance().getCurrentPrice() > 19_400){
                System.out.println(OrderSide.Buy + " 2");
            }

            startCount++;

            if (startCount == stopCount) {
                System.out.println(demo.getPrises());
            }
        }
    }
}
