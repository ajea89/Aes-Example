package com.example.ajea.aes.conection;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ajea on 26/05/16.
 */
public class GetConectionManager {

    public static final String BASEURL = "https://cirrus-staging.s.gigigoapps.com/";

    public static EndpointsEncript getServiceEncrip(){

        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient httpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(logging)
                .build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        EndpointsEncript service = retrofit.create(EndpointsEncript.class);

        return service;
    }
}
