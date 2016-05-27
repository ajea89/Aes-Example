package com.example.ajea.aes.beans;

/**
 * Created by ajea on 26/05/16.
 */
public class BodyEncript {

    private String FirstName;
    private String UserId;

    public BodyEncript(String firstName, String userId) {
        FirstName = firstName;
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
