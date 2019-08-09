package com.sematec.androidbasiccontact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtHello;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         txtHello = findViewById(R.id.txtHello);
        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnCall = findViewById(R.id.btnCall);



        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ProfileActivity.class  );
                startActivity(intent);

            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num = "tel:"+phone;

                Intent callintent = new Intent(Intent.ACTION_DIAL, Uri.parse(num));
                startActivity(callintent);
            }
        });


    }




}
