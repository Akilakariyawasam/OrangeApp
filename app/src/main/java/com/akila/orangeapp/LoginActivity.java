package com.akila.orangeapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
public static String UserName="";
    private Button signInBtn;
    private EditText userText;

    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInBtn = findViewById(R.id.btn_signin);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ServiceActivity.class);
                //intent.putExtra("name",userText.getText());
                startActivity(intent);
                finish();
            }
        });

        userText = findViewById(R.id.username_text);
        UserName = userText.getText().toString();
    }


}
