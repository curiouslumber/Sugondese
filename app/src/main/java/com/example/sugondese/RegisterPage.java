package com.example.sugondese;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText mName,mEmail,mPassword,mPassword2;
    Button RegisterBtn;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        mName = findViewById(R.id.editTextName);
        mEmail = findViewById(R.id.editTextEmail);
        mPassword = findViewById(R.id.editTextRPassword);
        mPassword2 = findViewById(R.id.editTextRPassword2);
        RegisterBtn = findViewById(R.id.button2);
        progressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
//        if (mAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),LoginPage.class));
//            finish();
//        }

        TextView textView = findViewById(R.id.textView2);

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
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String password2 = mPassword2.getText().toString().trim();

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
                            startActivity(new Intent(getApplicationContext(),LoginPage.class));

                        }

                        else {
                            Toast.makeText(RegisterPage.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}