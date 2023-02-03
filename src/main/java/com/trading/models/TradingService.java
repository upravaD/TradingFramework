package com.trading.models;

import com.trading.models.order.Symbol;
import com.trading.models.demo.DemoTrading;

public class TradingService {
    private final PlatformManager platformManager;

    public TradingService(PlatformManager platformManager) {
        this.platformManager = platformManager;
    }

    public void trade(int stopCount, double step, int level, double coef, Symbol symbol) {

        switch (platformManager) {
            case DEMO -> {
                DemoTrading demoTrading = new DemoTrading();
                demoTrading.startTrading(stopCount, step, level, coef, symbol);
            }
            case BITMEX -> {

            }
        }
    }
}
