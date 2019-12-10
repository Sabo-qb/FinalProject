package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        this.setTitle("Make Purchase");
        TextView title = findViewById(R.id.purchaseTitle);
        Intent intent = getIntent();
        String toTitle = "Purchase";
        switch(intent.getIntExtra("Product", -1)) {
            case 0:
                toTitle = getResources().getString(R.string.product0_title);
                break;
            case 1:
                toTitle = getResources().getString(R.string.product1_title);;
                break;
            case 2:
                toTitle = getResources().getString(R.string.product2_title);;
                break;
            default:
        }
        title.setText(toTitle);
        Button button = findViewById(R.id.buy);
        button.setOnClickListener(unused -> {
            sendEmail();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Continue Shopping?").setTitle("Purchase Complete!");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(PurchaseActivity.this, ShoppingActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(PurchaseActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
    private void sendEmail() {
        TextView email = findViewById(R.id.email);
        String emailAddress = email.getText().toString();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{emailAddress});
        i.putExtra(Intent.EXTRA_SUBJECT, "Your $300 Emporium Receipt");
        i.putExtra(Intent.EXTRA_TEXT   , getResources().getString(R.string.receipt));
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
