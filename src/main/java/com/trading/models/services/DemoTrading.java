package com.trading.models.services;

import com.trading.models.Demo;
import com.trading.models.TradingBot;
import com.trading.models.enums.OrderSide;
import com.trading.models.enums.PlatformManager;
import com.trading.models.enums.Symbol;

import java.time.LocalTime;
import java.util.Random;

public class DemoTrading {
    private final Demo demo;
    private final TradingBot tb;

    public DemoTrading() {
        this.demo = (Demo) PlatformManager.DEMO.getPlatform();
        demo.setStartPrice(20_000);
        this.tb = TradingBot.getInstance();
    }

    private void printStartPrice() {
        System.out.println("============================\n");
        System.out.println("Start Price = " + demo.getStartPrice() + " (" + Symbol.XBTUSD + ") ");
        System.out.println("\n============================");
    }

    private void printCurrentPrice() {
        System.out.println("Current Price = " + demo.getCurrentPrice() + " (" + Symbol.XBTUSD + ") { " + LocalTime.now() + " }");
        System.out.println("-".repeat(55));
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

    public void startTrading(int stopCount, double step, int level, double coef, Symbol symbol) {
        int startCount = 0;
        printStartPrice();

        tb.botInit(step,level,coef);

        while(startCount < stopCount) {
            updatePrice();

            openLongOrder(symbol);

            startCount++;

            if (startCount == stopCount) {
                System.out.println(demo.getPrises());
            }
        }
    }
    private void openLongOrder(Symbol symbol) {
        if (demo.getCurrentPrice() < demo.getStartPrice() - tb.getStep() && demo.getCurrentPrice() > demo.getStartPrice() - tb.getStep()*2) {
            System.out.println("Trading Bot open the long order with price = " + demo.getCurrentPrice());

            if (tb.getLevel() >= tb.getOrders().size()) {
                tb.setOrders(OrderSide.Buy, symbol);
            }

            demo.setStartPrice(demo.getCurrentPrice());
            closeLongOrder();

            System.out.println("-".repeat(55));
        }
    }

    private void closeLongOrder() {
        System.out.println((tb.getOrders().toString()));

        if (demo.getCurrentPrice() > demo.getStartPrice() + tb.getStep()) {
            tb.getOrders().remove(0);
            System.out.println("Long Order close");
        }
        System.out.println("OrdersList size: " + tb.getOrders().size());

        System.out.println((tb.getOrders().toString()));
    }
}
