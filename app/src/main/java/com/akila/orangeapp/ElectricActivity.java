package com.akila.orangeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ElectricActivity extends AppCompatActivity{

    private ImageView switchImage;
    private ImageView btnBack;
    private TextView backText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric);

        switchImage = findViewById(R.id.iv_switch);
        switchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElectricActivity.this, SwitchActivity.class);
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.iv_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElectricActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        backText = findViewById(R.id.tv_menu);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElectricActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

    }


}
