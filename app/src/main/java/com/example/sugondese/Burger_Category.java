package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Burger_Category extends AppCompatActivity {

    private static final String EXTRA_NAME = "com.example.intents.extra.NAME";
    CardView mcDonaldCardView, burgerKingCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_category);

        mcDonaldCardView = findViewById(R.id.activity_burger_category_mcDonaldCardView);
        burgerKingCardView = findViewById(R.id.activity_burger_category_burgerKingCardView);
        Intent i = new Intent(Burger_Category.this, ProductPage.class);

        mcDonaldCardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameText = "mcDonald";
                        i.putExtra(EXTRA_NAME, nameText);
                        startActivity(i);
                    }
                }
        );

        burgerKingCardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameText = "burgerKing";
                        i.putExtra(EXTRA_NAME, nameText);
                        startActivity(i);
                    }
                }
        );
    }
}