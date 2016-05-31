package com.example.ajea.aes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ajea on 31/05/16.
 */
public class MenuActivity extends AppCompatActivity {

    private Button btEnc;
    private Button btDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        btEnc = (Button) findViewById(R.id.bt_enc);
        btDes = (Button) findViewById(R.id.bt_des);

        btEnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, EncriptActivity.class);
                startActivity(intent);
            }
        });

        btDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, DesencripActivity.class);
                startActivity(intent);
            }
        });
    }
}
