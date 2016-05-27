package com.example.ajea.aes.security;

import android.util.Log;


public class LogD {

    public static final String TAG = LogD.class.getSimpleName();

    public static final boolean ENABLE_LOG = true;

    public static void i(String message) {
        if (ENABLE_LOG) {
            Log.i(TAG, message);
        }
    }
}
