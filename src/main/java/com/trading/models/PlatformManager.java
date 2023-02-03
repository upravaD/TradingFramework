package com.trading.models;

import com.trading.models.bitmex.Bitmex;
import com.trading.models.demo.Demo;

public enum PlatformManager {
    DEMO(Demo.getInstance()),
    BITMEX(new Bitmex());

    private final Object obj;

    PlatformManager(Object o) {
        this.obj = o;
    }

    public Object getPlatform() {
        return obj;
    }
}
