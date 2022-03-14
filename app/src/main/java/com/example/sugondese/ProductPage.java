package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductPage extends AppCompatActivity {

    String[] pizzeria = {"pizzeria", "pizzeria desc", "@drawable/pizza"};
    String[] smokeHouseDeli = {"Smoke House Deli", "Smoke House Deli desc", "@drawable/pizza2"};
    String[] mcDonald = {"Mc Donald's", "Mc Donald's", "@drawable/burger1"};
    String[] burgerKing = {"Burger King", "Burger King description", "@drawable/burger2"};
    String[] chinChinChu = {"Chin Chin Chu", "Chinese Desc", "@drawable/chinese2"};
    String[] tapRestro = {"TAP Restro", "TAP Restro Desc", "@drawable/chinese3"};
    String[] creamCentre = {"Cream Centre", "Cream Centre Desc", "@drawable/italian1"};
    String[] newYorkerRestaurant = {"New Yorker Restaurant", "New Yorker Restaurant desc", "@drawable/italian3"};

    TextView productTitle, productDes;
    ImageView productImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        Intent intent = getIntent();
        String name = intent.getStringExtra(Pizza_Category.EXTRA_NAME);

        String currentTitle = "";
        String currentDescription = "";

        productTitle = findViewById(R.id.product_page_title);
        productDes = findViewById(R.id.product_page_desc);
        productImg = findViewById(R.id.product_page_imageView);

        if(name.equals("pizzeria"))
        {
            productTitle.setText(pizzeria[0]);
            productDes.setText(pizzeria[1]);
            int imageResource = getResources().getIdentifier(pizzeria[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }
        if(name.equals("smokeHouseDeli"))
        {
            productTitle.setText(smokeHouseDeli[0]);
            productDes.setText(smokeHouseDeli[1]);
            int imageResource = getResources().getIdentifier(smokeHouseDeli[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }
        if(name.equals("mcDonald"))
        {
            productTitle.setText(mcDonald[0]);
            productDes.setText(mcDonald[1]);
            int imageResource = getResources().getIdentifier(mcDonald[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }
        if(name.equals("burgerKing"))
        {
            productTitle.setText(burgerKing[0]);
            productDes.setText(burgerKing[1]);
            int imageResource = getResources().getIdentifier(burgerKing[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }
        if(name.equals("chinChinChu"))
        {
            productTitle.setText(chinChinChu[0]);
            productDes.setText(chinChinChu[1]);
            int imageResource = getResources().getIdentifier(chinChinChu[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }
        if(name.equals("tapRestro")) {
            productTitle.setText(tapRestro[0]);
            productDes.setText(tapRestro[1]);
            int imageResource = getResources().getIdentifier(tapRestro[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }

        if(name.equals("creamCentre")) {
            productTitle.setText(creamCentre[0]);
            productDes.setText(creamCentre[1]);
            int imageResource = getResources().getIdentifier(creamCentre[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }

        if(name.equals("newYorkerRestaurant")) {
            productTitle.setText(newYorkerRestaurant[0]);
            productDes.setText(newYorkerRestaurant[1]);
            int imageResource = getResources().getIdentifier(newYorkerRestaurant[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
        }


    }
}