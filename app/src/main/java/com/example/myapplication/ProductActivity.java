package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Our Products");
        Intent intent = getIntent();
        int productNum = intent.getIntExtra("Product",-1);
        switch(productNum) {
            case 0:
                setContentView(R.layout.activity_product0);
                break;
            case 1:
                setContentView(R.layout.activity_product1);
                TextView price = findViewById(R.id.oldPrice);
                price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                break;
            case 2:
                setContentView(R.layout.activity_product2);
                break;
            default:
                setContentView(R.layout.activity_product);
        }
        Button button = findViewById(R.id.toPurchase);
        button.setOnClickListener(unused -> {
            Intent intent1 = new Intent(this, PurchaseActivity.class);
            intent1.putExtra("Product", productNum);
            startActivity(intent1);
        });
    }
}
