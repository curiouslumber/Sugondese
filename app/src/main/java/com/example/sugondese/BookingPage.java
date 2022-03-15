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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
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

    FirebaseFirestore db;
    String time, bookDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);

        restName = findViewById(R.id.rest_name);
        noPeople = findViewById(R.id.numberPeople);
        calendar = findViewById(R.id.calendarView);
        spin = findViewById(R.id.spinner);
        confirmBtn = findViewById(R.id.booking_confirmation);

        db = FirebaseFirestore.getInstance();

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
                 bookDate = i + "/" + i1 + "/" + i2;

            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num_people = noPeople.getText().toString();
                if(!num_people.equals("") ) {

                    if (TextUtils.isEmpty(num_people) ) {
                        noPeople.setError("Specify No. of People");
                    }

                    if (Integer.parseInt(num_people) > 20) {
                        noPeople.setError("Max Capacity is 20");
                    }
                }
//                int quantity = Integer.parseInt(num_people);

                addDataToFirestore(rest_name, Integer.parseInt(num_people),time, bookDate);


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        time = spin.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void addDataToFirestore(String restName, int quantity,  String date, String time) {

        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbCourses = db.collection("booking_details");

        // adding our data to our courses object class.
        BookingDetails courses = new BookingDetails(restName,  quantity,  date, time);

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(courses).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(getApplicationContext(), "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookingPage.this,ConfirmationPage.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(getApplicationContext(), "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}