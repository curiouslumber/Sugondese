package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chinese_Category extends AppCompatActivity {

    CardView chinChinChuCardView, tapRestroCardView;
    private static final String EXTRA_NAME = "com.example.intents.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_category);

        chinChinChuCardView = findViewById(R.id.activity_chinese_category_chinChinChuCardView);
        tapRestroCardView  = findViewById(R.id.activity_chinese_category_tapRestroCardView);
        Intent i = new Intent(Chinese_Category.this, ProductPage.class);

        chinChinChuCardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameText = "chinChinChu";
                        i.putExtra(EXTRA_NAME, nameText);
                        startActivity(i);
                    }
                }
        );

        tapRestroCardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameText = "tapRestro";
                        i.putExtra(EXTRA_NAME, nameText);
                        startActivity(i);
                    }
                }
        );
    }
}