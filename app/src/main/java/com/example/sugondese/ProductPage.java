package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProductPage extends AppCompatActivity {

    String[] pizzeria = {"Pizzeria", "Established in 2015 with a concept to bring the authenticity of Italian wood-fired pizza to India.\n" +
            "\n" +
            "1441 Pizzeria a venture by Trofi Chain Factory Private Limited is the first initiative from this culinary art house. It will be a one of its kind, traditional Italian Wood Fired Pizzeria with all of its food being made solely in the wood oven. The concept and menu have been designed and created by the Italian Pizza Master chef Renato Viola who will also be training the chefs personally.", "@drawable/pizza"};
    String[] smokeHouseDeli = {"Smoke House Deli", "We serve comfort food with a deep focus on ethically sourced local ingredients that are healthy, organic, and wholesome. Our produce comes straight from local farms across the country, so that you can enjoy the best of both flavour and health, handmade from scratch.", "@drawable/pizza2"};
    String[] mcDonald = {"Mc Donald's", "Everything from Burgers, fries, shakes, wraps to coffee, coolers and amazing beverages ! Back in 1954, a man named Ray Kroc discovered a small burger restaurant in California, and wrote the first page of our history. From humble beginnings as a small restaurant, we're proud to have become one of the world's leading food service brands with more than 36,000 restaurants in more than 100 countries.", "@drawable/burger1"};
    String[] burgerKing = {"Burger King", "Our Restaurants are known for serving high quality, great-tasting and affordable food. Founded in 1954, BURGER KING is the second largest fast food hamburger chain in  the world with about 18,000 restaurants operating in more than 100 countries and the US territories as of June 30, 2019. The original HOME OF THE WHOPPER, our commitment to ingredients, signature recipes and end-to-end online Burger King experience for millennials is what has defined our brand for more than 50 years.", "@drawable/burger2"};
    String[] chinChinChu = {"Chin Chin Chu", "Comfortable Seating Area, Gastronomical Experience, Fancy Crowd, Family Place, Good Quality Food, Courteous Staff. Come try our Crispy Prawn Cheung Fun, Chili Tofu, Duck Salad, Balinese Curry, Watermelon Drink, Sushi Platter to name a few !", "@drawable/chinese2"};
    String[] tapRestro = {"TAP Restro", "\"TAP '' Resto Bar at its best. Tap is an amalgamation of Lounge bar, sports bar, pub & a nightclub. A bold multi faceted venture by China Gate Group. Guests can choose from either unwinding, social gathering, partying hard or indulging themselves in any of featured gaming activities such as Dart machines, pool tables and more.  A new innovative 3 tier menu pricing concept makes it a wallet friendly affair. A haven for foodies showcasing a multi cuisine menu comprising of mexican, conti, indian & chinese offerings", "@drawable/chinese3"};
    String[] creamCentre = {"Cream Centre", "Cream Centre is a veg bistro serving global cuisine interpreted through an Indian lens. Over the last 63 Years, we have been serving an ever-evolving menu of casual comfort food that is created by a team of people who are passionate about discovering new tastes and ingredients, while staying true to our Indian roots.", "@drawable/italian1"};
    String[] newYorkerRestaurant = {"New Yorker Restaurant", "Perfect Location, Relaxed Atmosphere, Ample Seating Area, Decent Ambience, Family Restaurant. Burgers, pizzas, nachos & salads are served at this laid-back quick-serve restaurant.", "@drawable/italian3"};

    TextView productTitle, productDes;
    ImageView productImg;
    RatingBar rt;

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
        rt = findViewById(R.id.ratingBar);



        if(name.equals("pizzeria"))
        {
            productTitle.setText(pizzeria[0]);
            productDes.setText(pizzeria[1]);
            int imageResource = getResources().getIdentifier(pizzeria[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 3.5);
        }
        if(name.equals("smokeHouseDeli"))
        {
            productTitle.setText(smokeHouseDeli[0]);
            productDes.setText(smokeHouseDeli[1]);
            int imageResource = getResources().getIdentifier(smokeHouseDeli[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 4.0);
        }
        if(name.equals("mcDonald"))
        {
            productTitle.setText(mcDonald[0]);
            productDes.setText(mcDonald[1]);
            int imageResource = getResources().getIdentifier(mcDonald[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 3.0);
        }
        if(name.equals("burgerKing"))
        {
            productTitle.setText(burgerKing[0]);
            productDes.setText(burgerKing[1]);
            int imageResource = getResources().getIdentifier(burgerKing[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 4.1);
        }
        if(name.equals("chinChinChu"))
        {
            productTitle.setText(chinChinChu[0]);
            productDes.setText(chinChinChu[1]);
            int imageResource = getResources().getIdentifier(chinChinChu[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 3.7);
        }
        if(name.equals("tapRestro")) {
            productTitle.setText(tapRestro[0]);
            productDes.setText(tapRestro[1]);
            int imageResource = getResources().getIdentifier(tapRestro[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 4.2);
        }

        if(name.equals("creamCentre")) {
            productTitle.setText(creamCentre[0]);
            productDes.setText(creamCentre[1]);
            int imageResource = getResources().getIdentifier(creamCentre[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 2.7);
        }

        if(name.equals("newYorkerRestaurant")) {
            productTitle.setText(newYorkerRestaurant[0]);
            productDes.setText(newYorkerRestaurant[1]);
            int imageResource = getResources().getIdentifier(newYorkerRestaurant[2], null, getPackageName());
            Drawable img = getResources().getDrawable(imageResource);
            productImg.setImageDrawable(img);
            rt.setRating((float) 4.0);
        }


    }
}