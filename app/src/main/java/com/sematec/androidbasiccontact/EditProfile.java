package com.sematec.androidbasiccontact;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLDisplay;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnSave = findViewById(R.id.btnSave);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtFamilyName = findViewById(R.id.txtFamilyName);
        TextView txtPhone = findViewById(R.id.txtPhone);
        TextView txtAge = findViewById(R.id.txtAge);
        TextView txtAddress = findViewById(R.id.txtAddress);


        Intent intent = getIntent();
        final String name = intent.getStringExtra("name" );
        final String familyName = intent.getStringExtra("family name" );
        final String phone = intent.getStringExtra("phone" );
        final String age = intent.getStringExtra("age" );
        final String address = intent.getStringExtra("address");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PreferenceManager.getDefaultSharedPreferences(EditProfile.this).edit().putString("name" , name).apply();
                PreferenceManager.getDefaultSharedPreferences(EditProfile.this).edit().putString("phone" , phone).apply();
                PreferenceManager.getDefaultSharedPreferences(EditProfile.this).edit().putString("family name" , familyName).apply();
                PreferenceManager.getDefaultSharedPreferences(EditProfile.this).edit().putString("age" , age).apply();
                PreferenceManager.getDefaultSharedPreferences(EditProfile.this).edit().putString("address" , address).apply();

                Intent i =new Intent(EditProfile.this , ProfileActivity.class);
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edtIntent = new Intent(EditProfile.this , ProfileActivity.class);
                edtIntent.putExtra("name" , name);
                edtIntent.putExtra("family name" , familyName);
                edtIntent.putExtra("phone" , phone);
                edtIntent.putExtra("age" , age);
                edtIntent.putExtra("address" , address);
                startActivity(edtIntent);

            }
        });


        txtName.setText("name: " + name);
        txtFamilyName.setText("family name: " + familyName );
        txtPhone.setText("phone number: " + phone);
        txtAge.setText("age: " + age);
        txtAddress.setText("address: " + address);





    }
}
