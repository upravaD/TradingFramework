package com.trading.util;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
public class Expires {

    private final long expires;

    public Expires() {
        this.expires = Instant.now().getEpochSecond() + 100;
    }

    @Override
    public String toString() {
        return String.valueOf(expires);
    }
}
