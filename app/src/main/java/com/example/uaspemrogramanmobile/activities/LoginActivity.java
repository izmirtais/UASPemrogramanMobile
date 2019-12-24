package com.example.uaspemrogramanmobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uaspemrogramanmobile.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void handleMulai(View view) {
        Intent intent = new Intent(this, MulaiActivity.class);
        startActivity(intent);
    }
}
