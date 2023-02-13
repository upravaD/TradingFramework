package com.trading.model.order;

public enum OrderType {
    MARKET("Market"),
    LIMIT("Limit"),
    STOP_LIMIT("StopLimit"),
    MARKET_IF_TOUCHED("MarketIfTouched"),
    LIMIT_IF_TOUCHED("LimitIfTouched");

    private final String type;

    OrderType(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }
}
