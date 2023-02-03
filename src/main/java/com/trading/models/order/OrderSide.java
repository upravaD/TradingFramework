package com.trading.models.order;

public enum OrderSide {
    BUY ("BUY"),
    SELL ("SELL");
    private final String side;

    OrderSide(String side) {
        this.side = side;
    }

    public String get() {
        return side;
    }
}
