package com.trading.models.order;

public enum Symbol {
    XBTUSD ("XBTUSD");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
