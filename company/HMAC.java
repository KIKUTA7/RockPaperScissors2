package com.company;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Mac;
import java.security.NoSuchAlgorithmException;

public class HMAC {
    public static String HMAC() {
        try {
            String algorithm = "HmacSHA256";
            SecretKey hmacKey = generateHMACKey(algorithm);

            Mac mac = Mac.getInstance(algorithm);
            mac.init(hmacKey);

            byte[] bytes = mac.doFinal();
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException | java.security.InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SecretKey generateHMACKey(String algorithm) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
        return keyGen.generateKey();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

}
