package com.trading.controller;

public enum JSPManager {
    INDEX("/index.jsp");

    private final String path;

    JSPManager(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
