package com.example.sugondese;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;

public class HomePage extends AppCompatActivity {

   LinearLayout homepageIconBtn, profileIconBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID,phone,email,fName;
    TextView homeTV,profileTV;
    String homeColor = "white";
    String profileColor = "white";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_home_page);

        homepageIconBtn = findViewById(R.id.activity_home_page_homeFragmentBtn);
        profileIconBtn = findViewById(R.id.activity_home_page_profileFragmentBtn);
        homeTV = findViewById(R.id.activity_home_page_home);
        profileTV = findViewById(R.id.activity_home_page_profile);
        replaceFragment(new HomePageFragment());

        homeTV.setTextColor(Color.parseColor("#FF9700"));
        homeColor = "orange";
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        DocumentReference docRef = fStore.collection("users").document(userID);
        docRef.addSnapshotListener( this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                 phone = documentSnapshot.getString("phone");
                 fName = documentSnapshot.getString("fName");
                 email = documentSnapshot.getString("email");
            }
        });

        homepageIconBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(profileColor.equals("orange")){
                            profileTV.setTextColor(Color.parseColor("#545454"));
                            profileColor = "white";
                        }
                        homeTV.setTextColor(Color.parseColor("#FF9700"));
                        homeColor = "orange";
                        replaceFragment(new HomePageFragment());

                    }
                }
        );

        profileIconBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(homeColor.equals("orange")){
                            homeTV.setTextColor(Color.parseColor("#545454"));
                            homeColor = "white";
                        }
                        profileTV.setTextColor(Color.parseColor("#FF9700"));
                        profileColor = "orange";
                        replaceFragment(new AccountFragment(phone,fName,email));
                    }
                }
        );
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_home_page_frameLayout,fragment);
        fragmentTransaction.commit();

    }
}