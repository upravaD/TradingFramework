package com.trading.util;

import java.time.Instant;

public enum Expires {
    NEW((Instant.now().getEpochSecond() + 100) + "");

    private String expires = "";

    Expires(String expires) {
        this.expires = expires;
    }

    public String create() {
        return expires;
    }
}
