package com.example.sugondese;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterPage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText mName,mEmail,mPassword,mPassword2,mPhoneNo;
    Button RegisterBtn;
    ProgressBar progressBar;
    FirebaseFirestore fstore;
    String userID;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        mName = findViewById(R.id.activity_register_page_editTextName);
        mEmail = findViewById(R.id.activity_register_page_editTextEmail);
        mPassword = findViewById(R.id.activity_register_page_editTextRPassword);
        mPassword2 = findViewById(R.id.activity_register_page_editTextRPassword2);
        mPhoneNo = findViewById(R.id.activity_register_page_editTextPhoneNo);
        RegisterBtn = findViewById(R.id.activity_register_page_button2);
        progressBar = findViewById(R.id.activity_register_page_progressBar);

//        mPhoneNo.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD );

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
//        if (mAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),LoginPage.class));
//            finish();
//        }

        TextView textView = findViewById(R.id.activity_register_page_textView2);

        String text = "Already a user? Sign In";
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpanYellow = new ForegroundColorSpan(Color.parseColor("#FF9700"));
        spannableString.setSpan(foregroundColorSpanYellow, 16, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

        textView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(RegisterPage.this, LoginPage.class));
                    }
                }
        );

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = mName.getText().toString();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String password2 = mPassword2.getText().toString().trim();
                String phoneNo = mPhoneNo.getText().toString().trim();

                if(TextUtils.isEmpty(phoneNo)){
                    mPhoneNo.setError("Phone No. is required");
                }

                if(phoneNo.length()>10){
                    mPhoneNo.setError("Phone No. should be of 10 digits");
                }

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(getApplicationContext(), "Enter valid Email address !",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required.");
                    return;
                }

                if (TextUtils.isEmpty(password2)){
                    mPassword2.setError("Please confirm password.");
                    return;
                }

                if(password.compareTo(password2) != 0){
                    Toast.makeText(getApplicationContext(),"Please enter the same password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Password must be atleast 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // registering in firebase

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterPage.this, "User Created", Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference docRef = fstore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fName",fullName);
                            user.put("email",email);
                            user.put("phone",phoneNo);
                            docRef.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d("TAG","onSuccess: user Profile is created for"+ userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MyAccount.class));

                        }

                        else {
                            Toast.makeText(RegisterPage.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

    }
}