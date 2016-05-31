package com.example.ajea.aes.conection;

import com.example.ajea.aes.beans.MessageEncript;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by ajea on 26/05/16.
 */
public interface EndpointsEncript {

    @POST("/crypto/data/test")
    Call<MessageEncript> getencript(@Body String data);

    @POST("crypto/data/decrypt/test")
    Call<MessageEncript> getDesencript(@Body MessageEncript messageEncript);
}
