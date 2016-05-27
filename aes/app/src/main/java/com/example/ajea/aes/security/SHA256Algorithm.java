package com.example.ajea.aes.security;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


public class SHA256Algorithm {

    public static byte[] calculateSHA256(byte[] concatedIvWithAes256Data, byte[] key) {

        LogD.i("concatedIvWithAes256Data: " + Base64Encoder.encode(concatedIvWithAes256Data));

        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(key, "HmacSHA256");
            sha256Hmac.init(secretKey);

            byte[] bytesSha256 = sha256Hmac.doFinal(concatedIvWithAes256Data);

            LogD.i("SHA256: " +  Base64Encoder.encode(bytesSha256));

            return bytesSha256;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkAreEquals(byte[] concatedIvWithAes256Data, byte[] key, byte[] hMacByteArrayToCheck) {
        byte[] sha256 = calculateSHA256(concatedIvWithAes256Data, key);

        boolean areEquals = BytesUtils.checkAreEquals(sha256, hMacByteArrayToCheck);

        LogD.i("Son iguales AES: " +  areEquals + " - 1: " + Base64Encoder.encode(sha256) + " -- 2:" + Base64Encoder.encode(hMacByteArrayToCheck));

        return areEquals;
    }
}
