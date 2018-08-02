package com.akila.orangeapp;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import net.glxn.qrgen.android.QRCode;

import java.util.Random;

public class QRActivity extends AppCompatActivity{

    private static final String TAG = "QRActivity";

    private ImageView backImage;
    private TextView backText;
    private TextView textTotal;
    private TextView textDealer;
    private TextView textDealerName;
    private TextView textOrder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        backImage = (ImageView) findViewById(R.id.iv_back);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QRActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });

        backText = (TextView) findViewById(R.id.tv_menu);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QRActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });

        textTotal = (TextView) findViewById(R.id.txt_total);
        textTotal.setText(Double.toString(PayActivity.total));

//        textDealerName = (TextView) findViewById(R.id.txt_name);
//        textDealerName.setText(LoginActivity.name);



        int dealerId = randomInt(1,500);

        textDealer = (TextView) findViewById(R.id.txt_dealer);
        textDealer.setText(Integer.toString(dealerId));

        int orderId = randomInt(1,10);

        textOrder = (TextView) findViewById(R.id.txt_order);
        textOrder.setText(Integer.toString(orderId));


        Log.d(TAG, "onCreate: Total: " + PayActivity.total);

        String code = "9f53a89a-f1e3-4899-b68d-2d6ba449f014 " + PayActivity.total +"0"+ " main " +  Integer.toString(orderId);  //String code for qr
        Log.d(TAG, "onCreate: Code: " +code);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width_px = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height_px = Resources.getSystem().getDisplayMetrics().heightPixels;

        int pixeldpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        float pixeldp = Resources.getSystem().getDisplayMetrics().density;

        int width_dp = (width_px/pixeldpi)*160;
        int height_dp = (height_px/pixeldpi)*160;

        Bitmap myBitmap = QRCode.from(""+code).withSize(width_px,width_px).bitmap();
        ImageView myImage = (ImageView) findViewById(R.id.iv_qr);
        myImage.setImageBitmap(myBitmap);



        //for notification

        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter("Parameter.FCM_PUSH_NOTIFICATION"));
        FirebaseMessaging.getInstance().subscribeToTopic("all");




    }

    //   notification receving method

    private BroadcastReceiver mRegistrationBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("Parameter.FCM_PUSH_NOTIFICATION")) {
                Log.d("Message sending", " " + intent.getStringExtra("fcmData"));

                final String message = intent.getStringExtra("fcmData");

                final AlertDialog.Builder builder = new AlertDialog.Builder(QRActivity.this);
               runOnUiThread(new Runnable() {
                    public void run() {
                        if(message.contains("success")) {
                            builder.setTitle("Payment Successful");
                            builder.setMessage("Successfully Received the payment");
                            builder.setIcon(R.drawable.ic_sucess);
                        }
                        else{
                            builder.setTitle("Payment Failed");
                            builder.setMessage("Payment has been failed!");
                            builder.setIcon(R.drawable.ic_fail);
                        }
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(QRActivity.this, PayActivity.class));
                            }
                        });
                        builder.show();
                    }
                });



                Log.d("intent", " " + intent.getExtras());


            }
        }
    };

    //generate random index
    private int randomInt(int min, int max) {
        Random random = new Random();
        int x = random.nextInt(max - min + 1) + min;

        return x;
    }
}
