package com.sematec.androidbasiccontact;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView txtHello;
    EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtHello = findViewById(R.id.txtHello);

        edtName=findViewById(R.id.edtName);
       final EditText edtFamilyName=findViewById(R.id.edtFamilyName);
       final EditText edtAge=findViewById(R.id.edtAge);
       final EditText edtPhone=findViewById(R.id.edtPhone);
       final EditText edtAddress=findViewById(R.id.edtAddress);
       final Button btnDone = findViewById(R.id.btnDone);
       txtHello=findViewById(R.id.txtHello);
       String num= edtPhone.getText().toString();
       PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this )
               .edit()
               .putString("phone" , num)
               .apply();











         String name = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("name" , "Unknown");


        txtHello.setText( " Hello " + name);






                btnDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtName.getText().toString();
                        String familyName = edtFamilyName.getText().toString() ;
                        String address = edtAddress.getText().toString() ;
                        String age = edtAge.getText().toString() ;
                        String phone = edtPhone.getText().toString() ;


                        PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("name" , name).apply();


                        Intent doneIntent = new Intent(ProfileActivity.this , EditProfile.class);
                    doneIntent.putExtra("phone" , phone);
                    doneIntent.putExtra("name" , name);
                    doneIntent.putExtra("family name" , familyName);
                    doneIntent.putExtra("age" , age);
                    doneIntent.putExtra("address" , address);
                    Log.d("TAG" , "this is name " + name);

                    startActivityForResult(doneIntent , 11);

                    }
                });




        Intent edtIntent = getIntent();

       edtName.setText(edtIntent.getStringExtra("name" ));
        edtFamilyName.setText(edtIntent.getStringExtra("family name" ));
        edtAge.setText(edtIntent.getStringExtra("age" ));
        edtPhone.setText(edtIntent.getStringExtra("phone" ));
        edtAddress.setText(edtIntent.getStringExtra("address" ));




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11){
            if (resultCode == RESULT_OK){
            txtHello.setText("your information has been saved successfully");


            }
        }
    }
}
