package com.example.ajea.aes.security;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Encoder {

    private static final String UTF8 = "UTF-8";

    public static String encode(String stringToEncode) {
        try {
            byte[] bytesToEncode = stringToEncode.getBytes(UTF8);
            String encodedString = Base64.encodeToString(bytesToEncode, Base64.NO_WRAP);

            System.out.println("encoded value is: " + encodedString);

            return encodedString;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String encode(byte[] stringToEncode) {
        return Base64.encodeToString(stringToEncode, Base64.NO_WRAP);
    }

    public static byte[] decodeToByteArray(String stringToDecode) {
        return Base64.decode(stringToDecode, Base64.DEFAULT);
    }
}
