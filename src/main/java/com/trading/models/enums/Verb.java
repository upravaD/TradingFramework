package com.trading.models.enums;

public enum Verb {

    GET("GET"),
    POST("POST");

    private final String verb;

    Verb(String verb) {
        this.verb = verb;
    }

    public String getVerb() {
        return verb;
    }
}
