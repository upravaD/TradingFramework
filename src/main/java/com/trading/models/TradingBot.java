package com.trading.models;

import com.trading.models.enums.OrderSide;
import com.trading.models.enums.PlatformManager;
import com.trading.models.enums.Symbol;

public class TradingBot {
    private PlatformManager platformManager;
    private String apiKey;
    private String apiSecret;
    private Symbol symbol;
    private double step;
    private int level;
    private double coef;
    private OrderSide orderSide;

    public TradingBot() {

    }

    public TradingBot(PlatformManager platformManager, String apiKey, String apiSecret, Symbol symbol, double step, int level, double coef, OrderSide orderSide) {
        this.platformManager = platformManager;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.symbol = symbol;
        this.step = step;
        this.level = level;
        this.coef = coef;
        this.orderSide = orderSide;
    }

    public PlatformManager getPlatformManager() {
        return platformManager;
    }

    public void setPlatformManager(PlatformManager platformManager) {
        this.platformManager = platformManager;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide orderSide) {
        this.orderSide = orderSide;
    }
}
