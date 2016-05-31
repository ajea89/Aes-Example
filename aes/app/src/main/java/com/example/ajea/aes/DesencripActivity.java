package com.example.ajea.aes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajea.aes.beans.MessageEncript;
import com.example.ajea.aes.conection.GetConectionManager;
import com.example.ajea.aes.security.Base64Encoder;
import com.example.ajea.aes.security.Encrypter;
import com.example.ajea.aes.security.LogD;

import java.security.SecureRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by ajea on 31/05/16.
 */
public class DesencripActivity extends AppCompatActivity {

    private EditText etInputText;
    private TextView tvEnc;
    private TextView tvDes;
    private Button btInit;
    private ProgressBar progressBar;
    private boolean isEncript;
    private TextView labelEnc;
    private TextView labelDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desencrip_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etInputText = (EditText) findViewById(R.id.et_input);
        tvEnc = (TextView) findViewById(R.id.tv_enc);
        tvDes = (TextView) findViewById(R.id.tv_des);
        btInit = (Button) findViewById(R.id.bt_init);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        labelEnc = (TextView) findViewById(R.id.label_enc);
        labelDes = (TextView) findViewById(R.id.label_des);

        labelEnc.setText("Texto encriptado en app:");
        labelDes.setText("Texto desencriptado en servidor:");

        btInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etInputText.getText().toString();
                if (data != null && !data.isEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);
                    encriptTextFromApp(data);
                } else {
                    Toast.makeText(DesencripActivity.this, "Ingresa información a encriptar", Toast.LENGTH_SHORT);
                }
            }
        });

    }

    private void encriptTextFromApp(String data) {

        //generate random 16 byte IV AES is always 16bytes
        SecureRandom random = new SecureRandom();
        byte iv[] = new byte[16];
        random.nextBytes(iv);
        LogD.i("IV: " + Base64Encoder.encode(iv));

        String jsonFromData = "{\"data\": \"" + data + "\"}";
        String messageEnc = Encrypter.encrypt(MainActivity.KEY.getBytes(), iv, jsonFromData.getBytes());
        tvEnc.setText(messageEnc);

        /**
         * DECRYPTO API IMPLEMENTATION
         * **/

        MessageEncript messageEncript = new MessageEncript(messageEnc);
        Call<MessageEncript> getdecript = GetConectionManager.getServiceEncrip().getDesencript(messageEncript);
        getdecript.enqueue(new Callback<MessageEncript>() {
            @Override
            public void onResponse(Call<MessageEncript> call, Response<MessageEncript> response) {
                tvDes.setText(response.body().getMessage());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<MessageEncript> call, Throwable t) {
                Toast.makeText(DesencripActivity.this, "Ocurrio un error.", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
