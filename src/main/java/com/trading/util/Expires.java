package com.trading.util;

import java.time.Instant;

public enum Expires {
    NEW((Instant.now().getEpochSecond() + 100));

    private final String expires;

    Expires(long expires) {
        this.expires = String.valueOf(expires);
    }

    public String create() {
        return expires;
    }
}
