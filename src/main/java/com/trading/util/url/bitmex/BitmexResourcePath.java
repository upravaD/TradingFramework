package com.trading.util.url.bitmex;

public enum BitmexResourcePath {
    ORDER("/order"),
    POSITION("/position");

    private String resourcePath = "";

    BitmexResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String get() {
        return resourcePath;
    }
}