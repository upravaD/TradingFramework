package com.trading;

import com.trading.models.Demo;
import com.trading.models.TradingBot;
import com.trading.models.enums.OrderSide;
import com.trading.models.services.DemoTrading;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Trading Framework!");

        DemoTrading demoTrading = new DemoTrading();
        TradingBot tradingBot = new TradingBot();

        int x = 0;
        System.out.println(Demo.getInstance().getStartPrice());
        while(x < 25) {
            demoTrading.updatePrice();
            System.out.println(Demo.getInstance().getCurrentPrice());

            if (Demo.getInstance().getCurrentPrice() < 19_800 && Demo.getInstance().getCurrentPrice() > 19_600){
                System.out.println(OrderSide.Buy + " 1");
            }
            if (Demo.getInstance().getCurrentPrice() < 19_600 && Demo.getInstance().getCurrentPrice() > 19_400){
                System.out.println(OrderSide.Buy + " 2");
            }
            x++;
        }
    }
}
