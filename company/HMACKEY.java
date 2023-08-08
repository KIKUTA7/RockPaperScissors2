package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;

public class HMACKEY {

    public static String computeHMAC(String key, String move) throws NoSuchAlgorithmException, InvalidKeyException {
        String algorithm = "HmacSHA256";
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), algorithm);

        Mac mac = Mac.getInstance(algorithm);
        mac.init(secretKey);

        byte[] hmacBytes = mac.doFinal(move.getBytes(StandardCharsets.UTF_8));
        return byteArrayToHexString(hmacBytes);
    }

    private static String byteArrayToHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}

