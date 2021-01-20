package com.example.realopencv;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button CameraBtn = (Button)findViewById(R.id.CameraBtn);
        CameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Menu.this,MainActivity.class);
                startActivity(myintent);
                finish();
            }
        });


        Button BusInfoBtn = (Button)findViewById(R.id.BusInfoBtn);
        BusInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Menu.this,BusInfo.class);
                startActivity(myintent);
                finish();
            }
        });
        Button FindRoad = (Button)findViewById(R.id.findNaviBtn);
       FindRoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Menu.this,FindRoad.class);
                startActivity(myintent);
                finish();
            }
        });

    }



}

