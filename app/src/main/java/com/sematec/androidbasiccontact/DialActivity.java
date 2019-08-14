package com.sematec.androidbasiccontact;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial2);
        Button btnCall = findViewById(R.id.btnDial);
        final EditText edtPhone = findViewById(R.id.edtPhoneNumber);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = "tel: " + edtPhone.getText().toString();
                Intent dial = new Intent(Intent.ACTION_DIAL , Uri.parse(num));
                startActivity(dial);
            }
        });

    }
}
