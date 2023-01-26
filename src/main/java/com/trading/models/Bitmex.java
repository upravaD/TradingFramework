package com.trading.models;

import java.net.http.HttpClient;

/**
 *  Модель торговой платформы Bitmex
 */

public class Bitmex {
    private boolean isTestnet;
    private String apiKey;
    private String apiSecret;

    public Bitmex() {
    }

    private void bitmexInit(boolean isTestnet, String apiKey, String apiSecret) {
        this.isTestnet = isTestnet;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public String getNet() {
        return isTestnet ? "TESTNET" : "REALNET";
    }

    public void setTestnet(boolean testnet) {
        isTestnet = testnet;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }
}
