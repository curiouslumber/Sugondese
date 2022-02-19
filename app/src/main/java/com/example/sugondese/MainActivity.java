package com.example.sugondese;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView signUpTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpTV = findViewById(R.id.textView);

        String text = "Not a user yet? Sign Up";
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpanYellow = new ForegroundColorSpan(Color.parseColor("#FF9700"));
        spannableString.setSpan(foregroundColorSpanYellow, 16, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpTV.setText(spannableString);
    }
}