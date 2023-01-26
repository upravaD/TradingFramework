package com.trading.models.services;

import com.trading.models.Demo;
import com.trading.models.TradingBot;
import com.trading.models.enums.PlatformManager;

public class BotService {
    private final TradingBot tb;
    private final PlatformManager platformManager;

    public BotService(PlatformManager platformManager, TradingBot tb) {
        this.platformManager = platformManager;
        this.tb = tb;
    }

    public void buy() {
        if (platformManager == PlatformManager.DEMO) {
            createBuyOrder();
        }
    }

    private void createBuyOrder() {
        Demo demo = Demo.getInstance();
        if (demo.getCurrentPrice() < demo.getStartPrice() - tb.getStep() && demo.getCurrentPrice() > demo.getStartPrice() - tb.getStep()*2) {
            System.out.println("Trading Bot open the long order with price = " + demo.getCurrentPrice());
            tb.getOrders().remove(0);
            System.out.println("Orders size: " + tb.getOrders().size());
        }
    }
}
