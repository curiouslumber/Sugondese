package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationPage extends AppCompatActivity {

    TextView restName,date,time,num_people;
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        restName = findViewById(R.id.confirm_page_rest_name);
        date = findViewById(R.id.confirm_page_date);
        time = findViewById(R.id.confirm_page_time);
        num_people = findViewById(R.id.confirm_page_people);
        homeBtn = findViewById(R.id.confirm_page_goHome);

        MyDbHandler mydbhandler = new MyDbHandler(this, null, null, 1);

        Product product = mydbhandler.findProduct("1441 Pizzeria");
        if (product != null) {
            num_people.setText(String.valueOf(product.get_quantity()));
        } else {
            num_people.setText("No match found");
        }

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfirmationPage.this,HomePage.class));
            }
        });

    }
}