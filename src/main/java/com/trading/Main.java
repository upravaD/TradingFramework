package com.trading;

import com.trading.models.enums.PlatformManager;
import com.trading.models.enums.Symbol;
import com.trading.models.services.TradingService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Trading Framework!");

        TradingService tradingService = new TradingService(PlatformManager.DEMO);
        tradingService.trade(10, 200, 3, 1, Symbol.XBTUSD);
    }
}
