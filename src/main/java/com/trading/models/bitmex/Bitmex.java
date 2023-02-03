package com.trading.models.bitmex;

import com.trading.util.url.bitmex.BitmexURL;
import lombok.*;

/**
 *  Модель торговой платформы Bitmex
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Bitmex {
    private boolean isTestnet;
    private String apiKey;
    private String apiSecret;

    public String getNet() {
        return isTestnet ? BitmexURL.TEST.get() : BitmexURL.REAL.get();
    }
}



