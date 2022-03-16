package com.example.th05_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    private ImageView imgPicture;
    private TextView txtName2 ,txtDesciption2, txtPrice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgPicture = findViewById(R.id.imgPicture2);
        txtName2 = findViewById(R.id.txtName2);
        txtDesciption2 = findViewById(R.id.txtDesciption);
        txtPrice2 = findViewById(R.id.txtPrice2);

        Intent intent = getIntent();
        Product p = (Product) intent.getSerializableExtra("s");

        imgPicture.setImageResource(p.getPicture());
        txtName2.setText(p.getName());
        txtDesciption2.setText(p.getDiscription());
        txtPrice2.setText(String.valueOf(p.getPrice()));
    }
}