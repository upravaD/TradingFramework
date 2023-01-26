package com.trading;

import com.trading.models.services.DemoTrading;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Trading Framework!");

        DemoTrading demoTrading = new DemoTrading();
        demoTrading.startPlatform(10);
    }
}
