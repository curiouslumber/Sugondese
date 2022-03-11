package com.example.sugondese;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;

public class AccountFragment extends Fragment {

    TextView fullName, email, phone;
    String phone1,fname1,email1;

    public AccountFragment(String phone, String fName, String email) {
        phone1 = phone;
        fname1 = fName;
        email1 = email;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.temp_acc_frag, container, false);

        Button testBtn = view.findViewById(R.id.fragment_account_logBtn);
        fullName = view.findViewById(R.id.fragment_account_fullname);
        email = view.findViewById(R.id.fragment_account_email);
        phone = view.findViewById(R.id.fragment_account_phoneNo);

        phone.setText(phone1);
        email.setText(email1);
        fullName.setText(fname1);



                testBtn.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(AccountFragment.this.getContext(), LoginPage.class));
                            }
                        }
                );



        return view;
    }
}