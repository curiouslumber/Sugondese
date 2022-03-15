package com.example.sugondese;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;

public class BookingPage extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    TextView restName;
    EditText noPeople;
    CalendarView calendar;
    Spinner spin;
    Button confirmBtn;
    String[] times = {"12 PM","1 PM","2 PM","3 PM","4 PM","5 PM","6 PM",
    "7 PM","8 PM","9 PM","10 PM"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);

        restName = findViewById(R.id.rest_name);
        noPeople = findViewById(R.id.numberPeople);
        calendar = findViewById(R.id.calendarView);
        spin = findViewById(R.id.spinner);
        confirmBtn = findViewById(R.id.booking_confirmation);

        MyDbHandler mydbhandler = new MyDbHandler(this, null, null, 1);

        Bundle bundle = getIntent().getExtras();
        String rest_name = bundle.getString("abc");
        restName.setText(String.valueOf(rest_name));

        spin.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,times);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin.setAdapter(adapter);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String bookDate = i + "/" + i1 + "/" + "i2";

            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num_people = noPeople.getText().toString();

                if (TextUtils.isEmpty(num_people)){
                    noPeople.setError("Specify No. of People");
                }

                if (Integer.parseInt(num_people) > 20){
                    noPeople.setError("Max Capacity is 20");
                }

                int quantity = Integer.parseInt(num_people);
                Product product = new Product("1441 Pizzeria", quantity);
                Boolean test = mydbhandler.addProducts(product);
                if (test)
                    Toast.makeText(getApplicationContext(), "Record inserted" + test, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "<<<---ERROR--->>" + test, Toast.LENGTH_LONG).show();

                startActivity(new Intent(BookingPage.this,ConfirmationPage.class));

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = spin.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}