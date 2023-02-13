package com.trading.model.order;

public enum OrderSide {
    BUY ("Buy"),
    SELL ("Sell");
    private final String side;

    OrderSide(String side) {
        this.side = side;
    }

    public String get() {
        return side;
    }
}
