package com.trading.models.order;

public enum OrderType {
    MARKET("MARKET"),
    LIMIT("LIMIT"),
    STOP_LIMIT("STOP LIMIT"),
    MARKET_IF_TOUCHED("MARKET IF TOUCHED"),
    LIMIT_IF_TOUCHED("LIMIT IF TOUCHED");

    private final String type;

    OrderType(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }
}
