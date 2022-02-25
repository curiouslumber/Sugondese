package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView signUpTV = findViewById(R.id.textView);

        String text = "Not a user yet? Sign Up";
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpanYellow = new ForegroundColorSpan(Color.parseColor("#FF9700"));
        spannableString.setSpan(foregroundColorSpanYellow, 16, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpTV.setText(spannableString);

        signUpTV.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(LoginPage.this, RegisterPage.class));
                    }
                }
        );
    }
}