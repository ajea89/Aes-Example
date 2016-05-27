package com.example.ajea.aes.conection;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by ajea on 26/05/16.
 */
public class GetConectionManager {

    public static final String BASEURL = "https://cirrus-staging.s.gigigoapps.com/";

    public static EndpointsEncript getServiceEncrip(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndpointsEncript service = retrofit.create(EndpointsEncript.class);

        return service;
    }
}
