package com.akila.orangeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SwitchActivity extends AppCompatActivity{

    private ImageView casblancaImage;
    private ImageView btnBack;
    private TextView backText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        casblancaImage = findViewById(R.id.iv_casblanca);
        casblancaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SwitchActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.iv_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SwitchActivity.this, ElectricActivity.class);
                startActivity(intent);
            }
        });

        backText = findViewById(R.id.tv_menu);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SwitchActivity.this, ElectricActivity.class);
                startActivity(intent);
            }
        });
    }
}
