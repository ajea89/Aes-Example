package com.example.ajea.aes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ajea.aes.beans.BodyEncript;
import com.example.ajea.aes.beans.ResultEncript;
import com.example.ajea.aes.conection.GetConectionManager;
import com.example.ajea.aes.security.Encrypter;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "4497fdeb58be85a94b168b2ea8ad691e";

    private ProgressBar progressBar;
    private TextView tvMessaje;
    private TextView tvEncript;
    private TextView tvHmac;
    private TextView tvIv;
    private TextView tvKey;
    private TextView tvInfoDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tvMessaje = (TextView) findViewById(R.id.tv_messaje);
        tvEncript = (TextView) findViewById(R.id.tv_encript);
        tvHmac = (TextView) findViewById(R.id.tv_hmac);
        tvIv = (TextView) findViewById(R.id.tv_iv);
        tvKey = (TextView) findViewById(R.id.tv_key);
        tvInfoDes = (TextView) findViewById(R.id.tv_info_des);

        /**
         * ENCRIPT API IMPLEMENTATION
         * **/

        Call<ResultEncript> getResponseEncript = GetConectionManager.getServiceEncrip().getencript(new BodyEncript("Este es un mensaje de prueba" , "123456"));

        getResponseEncript.enqueue(new Callback<ResultEncript>() {
            @Override
            public void onResponse(Response<ResultEncript> response, Retrofit retrofit) {
                showInfo(response.body());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainActivity.this, "Ocurrio un error.", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    /**
     * Show info readed from API
     **/
    private void showInfo(ResultEncript body) {
        tvMessaje.setText("FirstName: " + body.getMessageSinEncriptar().getFirstName() + "\nUserId: " + body.getMessageSinEncriptar().getUserId());
        tvEncript.setText(body.getMessageEncriptado());
        tvHmac.setText(body.getHmac());
        tvIv.setText(body.getIV());
        tvKey.setText(body.getKey());

        desEncriptInfo(body);
    }

    /**
     * Desencript Info
     * **/
    private void desEncriptInfo(ResultEncript body) {
        tvInfoDes.setText(Encrypter.decrypt(body.getMessageEncriptado(), KEY.getBytes()));
    }
}
