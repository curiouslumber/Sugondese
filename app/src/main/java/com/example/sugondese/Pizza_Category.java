package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pizza_Category extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.intents.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_category);

        CardView pizzeriaCard = findViewById(R.id.activity_pizza_category_pizzeriaCard);
        CardView smokeHouseDeliCard = findViewById(R.id.activity_pizza_category_smokeHouseDeliCard);

        Intent i = new Intent(Pizza_Category.this, ProductPage.class);
         pizzeriaCard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameText = "pizzeria";
                        i.putExtra(EXTRA_NAME, nameText);
                        startActivity(i);
                    }
                }
        );

         smokeHouseDeliCard.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         String nameText = "smokeHouseDeli";
                         i.putExtra(EXTRA_NAME, nameText);
                         startActivity(i);
                     }
                 }
         );


    }
}