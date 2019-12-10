package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Welcome");
        Button button = findViewById(R.id.begin);
        button.setOnClickListener((unused -> startActivity(new Intent(this, ShoppingActivity.class))));
    }
}
