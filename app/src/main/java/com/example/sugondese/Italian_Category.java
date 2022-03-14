package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Italian_Category extends AppCompatActivity {

    CardView creamCentreCardView, newYorkerRestaurantCardView;
    private static final String EXTRA_NAME = "com.example.intents.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_category);

        creamCentreCardView = findViewById(R.id.activity_italian_category_creamCentreCardView);
        newYorkerRestaurantCardView = findViewById(R.id.activity_italian_category_newYorkerRestaurantCardView);
        Intent i = new Intent(Italian_Category.this, ProductPage.class);

        creamCentreCardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameText = "creamCentre";
                        i.putExtra(EXTRA_NAME, nameText);
                        startActivity(i);
                    }
                }
        );

        newYorkerRestaurantCardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameText = "newYorkerRestaurant";
                        i.putExtra(EXTRA_NAME, nameText);
                        startActivity(i);
                    }
                }
        );


    }
}