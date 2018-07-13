package com.akila.orangeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "PAY_ACTIVITY";
    private Spinner itemCount1;
    private Spinner itemCount2;
    private Spinner itemCount3;
    private Spinner itemCount4;
    private Spinner itemCount5;
    private Spinner itemCount6;
    private Spinner itemCount7;
    private Spinner itemCount8;
    private Spinner itemCount9;
    private Spinner itemCount10;
    private Spinner itemCount11;
    private Spinner itemCount12;
    private Spinner itemCount13;
    private Spinner itemCount14;
    private Spinner itemCount15;
    private Spinner itemCount16;
    private Spinner itemCount17;
    private Spinner itemCount18;
    private Spinner itemCount19;
    private Spinner itemCount20;
    private Spinner itemCount21;
    private Spinner itemCount22;

    private TextView itemText;
    private TextView totalText;
    private ImageView btnBack;
    private Button btnPay;
    private TextView backText;

    int currentValue;
    String value;
    String totalValue;
    int positionValue = 0;
    static double total = 0;

    ArrayList<Integer> resourceId = new ArrayList<>();      //storing selected checkbox ids


    static Integer[] spinnerArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private List<Integer> spinnerArray = Arrays.asList(spinnerArr);
    private ProductController productController;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        productController = new ProductController();


        itemText = findViewById(R.id.tv_item);
        totalText = findViewById(R.id.tv_total);

        btnBack = findViewById(R.id.iv_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this, SwitchActivity.class);
                startActivity(intent);
            }
        });

        backText = findViewById(R.id.tv_menu);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this, SwitchActivity.class);
                startActivity(intent);
            }
        });
        btnPay = findViewById(R.id.btn_pay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this, QRActivity.class);
                startActivity(intent);
            }
        });

        itemCount1 = (Spinner) findViewById(R.id.spin1);
        itemCount2 = (Spinner) findViewById(R.id.spin2);
        itemCount3 = (Spinner) findViewById(R.id.spin3);
        itemCount4 = (Spinner) findViewById(R.id.spin4);
        itemCount5 = (Spinner) findViewById(R.id.spin5);
        itemCount6 = (Spinner) findViewById(R.id.spin6);
        itemCount7 = (Spinner) findViewById(R.id.spin7);
        itemCount8 = (Spinner) findViewById(R.id.spin8);
        itemCount9 = (Spinner) findViewById(R.id.spin9);
        itemCount10 = (Spinner) findViewById(R.id.spin10);
        itemCount11 = (Spinner) findViewById(R.id.spin11);
        itemCount12 = (Spinner) findViewById(R.id.spin12);
        itemCount13 = (Spinner) findViewById(R.id.spin13);
        itemCount14 = (Spinner) findViewById(R.id.spin14);
        itemCount15 = (Spinner) findViewById(R.id.spin15);
        itemCount16 = (Spinner) findViewById(R.id.spin16);
        itemCount17 = (Spinner) findViewById(R.id.spin17);
        itemCount18 = (Spinner) findViewById(R.id.spin18);
        itemCount19 = (Spinner) findViewById(R.id.spin19);
        itemCount20 = (Spinner) findViewById(R.id.spin20);
        itemCount21 = (Spinner) findViewById(R.id.spin21);
        itemCount22 = (Spinner) findViewById(R.id.spin22);

        // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item, spinnerArray

        );
        //Applying adapter to the spinnners
        itemCount1.setAdapter(adapter);
        itemCount2.setAdapter(adapter);
        itemCount3.setAdapter(adapter);
        itemCount4.setAdapter(adapter);
        itemCount5.setAdapter(adapter);
        itemCount6.setAdapter(adapter);
        itemCount7.setAdapter(adapter);
        itemCount8.setAdapter(adapter);
        itemCount9.setAdapter(adapter);
        itemCount10.setAdapter(adapter);
        itemCount11.setAdapter(adapter);
        itemCount12.setAdapter(adapter);
        itemCount13.setAdapter(adapter);
        itemCount14.setAdapter(adapter);
        itemCount15.setAdapter(adapter);
        itemCount16.setAdapter(adapter);
        itemCount17.setAdapter(adapter);
        itemCount18.setAdapter(adapter);
        itemCount19.setAdapter(adapter);
        itemCount20.setAdapter(adapter);
        itemCount21.setAdapter(adapter);
        itemCount22.setAdapter(adapter);



    }


    private void setProduct(int id, int price, int qty) {
        Log.d(TAG, "setProduct() called with: id = [" + id + "], price = [" + price + "], qty = [" + qty + "]");
        Product product = new Product();

        product.setId(id);
        product.setPrice(price);
        product.setQty(qty);

        productController.addOrUpdate(product);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        Log.i(TAG, "onCheckboxClicked: checked[" + checked + "]");
        currentValue = checked ? ++currentValue : --currentValue;
        itemText.setText(String.valueOf(currentValue));

        Log.i(TAG, "onCheckboxClicked: current_value[" + currentValue + "]");
        // Check which checkbox was clicked

        if (!checked) {
            productController.removeProduct(view.getId());
        }
        switch (view.getId()) {
            case R.id.check1:
                if (checked) {
                    setProduct(view.getId(), 150, spinnerArr[itemCount1.getSelectedItemPosition()]);
                    ProductController.calcTotal();
                }
                break;
            case R.id.check2:
                if (checked) {
                    setProduct(view.getId(), 35, spinnerArr[itemCount2.getSelectedItemPosition()]);
                    ProductController.calcTotal();
                } else {

                }
                break;
            case R.id.check3:
                if (checked) {
                    setProduct(view.getId(), 175, spinnerArr[itemCount3.getSelectedItemPosition()]);
                    ProductController.calcTotal();
                } else {

                }
                break;
            case R.id.check4:
                if (checked) {
                    setProduct(view.getId(), 250, spinnerArr[itemCount4.getSelectedItemPosition()]);

                } else {

                }
                break;
            case R.id.check5:
                if (checked) {
                    setProduct(view.getId(), 325, spinnerArr[itemCount5.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check6:
                if (checked) {
                    setProduct(view.getId(), 100, spinnerArr[itemCount6.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check7:
                if (checked) {
                    setProduct(view.getId(), 75, spinnerArr[itemCount7.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check8:
                if (checked) {
                    setProduct(view.getId(), 32, spinnerArr[itemCount8.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check9:
                if (checked) {
                    setProduct(view.getId(), 50, spinnerArr[itemCount9.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check10:
                if (checked) {
                    setProduct(view.getId(), 50, spinnerArr[itemCount10.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check11:
                if (checked) {
                    setProduct(view.getId(), 75, spinnerArr[itemCount11.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check12:
                if (checked) {
                    setProduct(view.getId(), 75, spinnerArr[itemCount12.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check13:
                if (checked) {
                    setProduct(view.getId(), 65, spinnerArr[itemCount13.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check14:
                if (checked) {
                    setProduct(view.getId(), 55, spinnerArr[itemCount14.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check15:
                if (checked) {
                    setProduct(view.getId(), 85, spinnerArr[itemCount15.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check16:
                if (checked) {
                    setProduct(view.getId(), 95, spinnerArr[itemCount16.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check17:
                if (checked) {
                    setProduct(view.getId(), 55, spinnerArr[itemCount17.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check18:
                if (checked) {
                    setProduct(view.getId(), 47, spinnerArr[itemCount18.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check19:
                if (checked) {
                    setProduct(view.getId(), 58, spinnerArr[itemCount19.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check20:
                if (checked) {
                    setProduct(view.getId(), 58, spinnerArr[itemCount20.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check21:
                if (checked) {
                    setProduct(view.getId(), 85, spinnerArr[itemCount21.getSelectedItemPosition()]);
                } else {

                }
                break;
            case R.id.check22:
                if (checked) {
                    setProduct(view.getId(), 75, spinnerArr[itemCount22.getSelectedItemPosition()]);
                } else {

                }
                break;

        }
        //calculating total
        total = ProductController.calcTotal();
        Log.i(TAG, "onCheckboxClicked: Total[" + total + "]");

        totalValue = Double.toString(total);
        totalText.setText(totalValue);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
