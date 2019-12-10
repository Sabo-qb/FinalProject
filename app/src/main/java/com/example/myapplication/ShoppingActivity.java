package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Our Products");
        setSupportActionBar(toolbar);
        Intent intent = new Intent(this, ProductActivity.class);
        ImageView product0 = findViewById(R.id.product0);
        product0.setOnClickListener(unused -> {
            intent.putExtra("Product", 0);
            startActivity(intent);
        });
        ImageView product1 = findViewById(R.id.product1);
        product1.setOnClickListener(unused -> {
            intent.putExtra("Product", 1);
            startActivity(intent);
        });
        ImageView product2 = findViewById(R.id.product2);
        product2.setOnClickListener(unused -> {
            intent.putExtra("Product", 2);
            startActivity(intent);
        });
    }
}
