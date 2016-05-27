package com.example.ajea.aes.security;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class BytesUtils {

    public static byte[] concatByteArrays(byte[] a, byte[] b) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
            outputStream.write(a);
            outputStream.write(b);
            return outputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] obtainByteArray(byte[] byteArray, int offset, int lenght) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(byteArray, offset, lenght);
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkAreEquals(byte[] a, byte[] b) {
        return Arrays.equals(a, b);
    }
}
