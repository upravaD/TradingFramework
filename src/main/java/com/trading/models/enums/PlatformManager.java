package com.trading.models.enums;

import com.trading.models.Bitmex;
import com.trading.models.Demo;

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
