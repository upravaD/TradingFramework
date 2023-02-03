package com.trading.util.url;

public enum Verb {

    GET("GET"),
    POST("POST");

    private final String verb;

    Verb(String verb) {
        this.verb = verb;
    }

    public String get() {
        return verb;
    }
}
