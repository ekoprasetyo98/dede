package com.example.dedee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HasilDiagnosa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosa);
        TextView edNamaPenyakit;
        String JenisDermatitis;

        Intent intent = getIntent();
        JenisDermatitis = intent.getStringExtra("Jenis Dermatitis");




    }
}
