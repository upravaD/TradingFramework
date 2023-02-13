package com.trading.model.order;

public enum Symbol {
    XBTUSD ("XBTUSD"),
    BMEXUSDT ("BMEXUSDT"),
    DOGEUSD ("DOGEUSD");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String get() {
        return symbol;
    }
}
