package com.example.sugondese;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    Button forgetBtn;
    EditText txtEmail;
    TextView backToLogin;
    String email;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        fauth = FirebaseAuth.getInstance();
        txtEmail = findViewById(R.id.activity_forgot_password_ForgetEmail);
        backToLogin = findViewById(R.id.activity_forgot_password_backToLogin);
        forgetBtn = findViewById(R.id.activity_forgot_password_forgot_button);

        TextView signUpTV = findViewById(R.id.activity_forgot_password_textView);

        String text = "Not a user yet? Sign Up";
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpanYellow = new ForegroundColorSpan(Color.parseColor("#FF9700"));
        spannableString.setSpan(foregroundColorSpanYellow, 16, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpTV.setText(spannableString);

        signUpTV.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(ForgotPassword.this, RegisterPage.class));
                    }
                }
        );



        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPassword.this,LoginPage.class));
            }
        });


        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateData();
            }
        });


    }

    private void validateData() {
        email = txtEmail.getText().toString();
        if(email.isEmpty()){
            txtEmail.setError("Required");
        }
        else{
            forgetPass();
        }
    }

    private void forgetPass() {
        fauth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check your Email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgotPassword.this, LoginPage.class));
                    finish();
                }
                else {
                    Toast.makeText(ForgotPassword.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}