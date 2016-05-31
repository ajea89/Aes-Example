package com.example.ajea.aes.beans;

import com.google.gson.annotations.Expose;

/**
 * Created by ajea on 30/05/16.
 */
public class MessageEncript {

    @Expose
    private String data;

    public MessageEncript(String data) {
        this.data = data;
    }

    public String getMessage() {
        return data;
    }

    public void setMessage(String data) {
        this.data = data;
    }
}
