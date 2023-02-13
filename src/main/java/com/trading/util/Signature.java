package com.trading.util;

import com.trading.util.url.URL;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Создание сигнатур авторизации
 */

public class Signature {
    private byte[] calcHmacSha256(byte[] secretKey, byte[] message) {
        byte[] hmacSha256;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        return hmacSha256;
    }

    private byte[] calcSha256(String verb, String path, String data, String expires, String apiSecret) {
        return calcHmacSha256(apiSecret.getBytes(StandardCharsets.UTF_8),
                (verb + path + expires + data).getBytes(StandardCharsets.UTF_8));
    }

    private String convertToString(byte[] sha256) {
        return String.format("%032x", new BigInteger(1, sha256));
    }

    public String createSignature(URL url, String verb, String data, String expires, String apiSecret) {
        System.out.println("URL: " + url);
        String path = url.getApiPath() + url.getResourcePath();

        System.out.println("Send: [" + verb + ", " + path + ", " + data + ", " + expires + ", " + apiSecret + "]");
        String result = convertToString(calcSha256(verb, path, data, expires, apiSecret));

        if (result.length() != 64) {
            result = convertToString(calcSha256(verb, path, data, expires, apiSecret));
        }
        System.out.println("Signature: " + result);
        return result;
    }
}
