package com.trading.util.url.bitmex;

public enum BitmexURL {
    PROTOCOL ("https://"),
    TEST ("testnet."),
    REAL ("www."),
    BASE_URL ("bitmex.com"),
    API_PATH ("/api/v1");

    private String bitmexUrl = "";

    BitmexURL(String bitmexUrl) {
        this.bitmexUrl = bitmexUrl;
    }

    public String get() {
        return bitmexUrl;
    }
}
