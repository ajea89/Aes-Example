package com.example.ajea.aes.conection;

import com.example.ajea.aes.beans.BodyEncript;
import com.example.ajea.aes.beans.ResultEncript;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by ajea on 26/05/16.
 */
public interface EndpointsEncript {

    @POST("crypto/test")
    Call<ResultEncript> getencript(@Body BodyEncript bodyEncript);
}
