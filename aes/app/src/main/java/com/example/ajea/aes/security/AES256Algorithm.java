package com.example.ajea.aes.security;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AES256Algorithm {

    public static byte[] encrypt(byte[] key, byte[] iv, byte[] dataToEncrypt) {

        try {
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            SecretKeySpec newKey = new SecretKeySpec(key, "AES_256");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
            byte[] encryptedBytes = cipher.doFinal(dataToEncrypt);

            LogD.i("Encoded String: " + Base64Encoder.encode(encryptedBytes));

            return encryptedBytes;

        } catch (Exception e) {
            return null;
        }
    }

    //TODO
    public static byte[] decrypt(byte[] ivBytes, byte[] keyBytes, byte[] textBytes) {
        try {
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES_256");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);

            byte[] decryptedBytes = cipher.doFinal(textBytes);

            return decryptedBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
