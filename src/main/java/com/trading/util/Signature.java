package com.trading.util;

import com.trading.util.url.URL;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * Создание сигнатур авторизации
 */

public class Signature {

    private byte[] calcSha256(String verb, String path, String data, String expires, String apiSecret) {
        HMAC hmac = new HMAC();
        return hmac.calcHmacSha256(apiSecret.getBytes(StandardCharsets.UTF_8),
                (verb + path + data + expires).getBytes(StandardCharsets.UTF_8));

    }

    private String convertToString(byte[] sha256) {
        String signatureStr = "";
        signatureStr = String.format("%032x", new BigInteger(1, sha256));
        return signatureStr;
    }

    public String createSignature(URL url, String verb, String data, String expires, String apiSecret) {
        String path = url.getApiPath() + url.getResourcePath();
        return convertToString(calcSha256(verb, path, data, expires, apiSecret));
    }
}
