package com.trading.util.url.bitmex;

public enum BitmexResourcePath {
    ORDER("/order"),
    INSTRUMENT("/instrument"),
    POSITION("/position"),
    ORDER_BOOK("/orderBook/L2");

    private String resourcePath = "";

    BitmexResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String get() {
        return resourcePath;
    }
}