package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class ConfirmationPage extends AppCompatActivity {

    TextView restName,date,time,num_people;
    Button homeBtn;
    String userIdS;
    String restNameS, timeS, dateS;
    int quantity;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        restName = findViewById(R.id.confirm_page_rest_name);
        date = findViewById(R.id.confirm_page_date);
        time = findViewById(R.id.confirm_page_time);
        num_people = findViewById(R.id.confirm_page_people);
        homeBtn = findViewById(R.id.confirm_page_goHome);
        db = FirebaseFirestore.getInstance();

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfirmationPage.this,HomePage.class));
            }
        });

    }
}