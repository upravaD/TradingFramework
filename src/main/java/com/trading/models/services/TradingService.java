package com.trading.models.services;

import com.trading.models.enums.PlatformManager;
import com.trading.models.enums.Symbol;

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
