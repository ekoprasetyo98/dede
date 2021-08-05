package com.example.dedee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class profilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        getSupportActionBar().hide();
    }
}
