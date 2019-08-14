package com.sematec.androidbasiccontact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Button btnDrawer = findViewById(R.id.btnDrawerLayout);
         recyclerView = findViewById(R.id.recycler_view);
        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

       btnDrawer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

            drawerLayout.openDrawer(Gravity.START);

           }
       });
        List<String> list = new ArrayList<>();
        list.add(0 , "dial");
        list.add(1 , "profile");
        list.add(2 , "Calendar");



        Adapter adapter = new Adapter(list , MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this , LinearLayout.VERTICAL , false));







    }



}



