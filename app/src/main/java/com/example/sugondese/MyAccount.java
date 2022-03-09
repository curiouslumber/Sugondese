package com.example.sugondese;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MyAccount extends AppCompatActivity {
//
//    Button Btn;
//    TextView fullName,email,phone;
//    FirebaseAuth fAuth;
//    FirebaseFirestore fStore;
//    String userID;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_account);
//        fullName = findViewById(R.id.textViewName);
//        email = findViewById(R.id.textViewEmail);
//        phone = findViewById(R.id.textViewPhone);
//        Btn = findViewById(R.id.alogButton);
//
//        fAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();
//
//        userID = fAuth.getCurrentUser().getUid();
//
//        DocumentReference docRef = fStore.collection("users").document(userID);
//        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//               phone.setText(documentSnapshot.getString("phone"));
//               fullName.setText(documentSnapshot.getString("fName"));
//               email.setText(documentSnapshot.getString("email"));
//            }
//        });
//
//
//        Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MyAccount.this,LoginPage.class));
//            }
//        });
//    }
}