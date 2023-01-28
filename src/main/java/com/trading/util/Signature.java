package com.trading.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * Создание сигнатур авторизации
 */

public class Signature {

    public byte[] createBitmexSignature(String verb, String path, String data, String expires, String apiSecret) {
        HMAC hmac = new HMAC();
        return hmac.calcHmacSha256(apiSecret.getBytes(StandardCharsets.UTF_8),
                (verb + path + data + expires).getBytes(StandardCharsets.UTF_8));
    }

    public String signatureToString(byte[] signature) {
        String signatureSTR;
        signatureSTR = String.format("%032x", new BigInteger(1, signature));
        return signatureSTR;
    }
}
