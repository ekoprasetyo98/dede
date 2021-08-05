package com.example.dedee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class EducationActivity extends AppCompatActivity {
    LinearLayout atopic, kontak, neuro, alergi;
    CardView diagnosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        getSupportActionBar().hide();

        atopic = findViewById(R.id.edukasiAtopic);
        kontak = findViewById(R.id.edukasiKontak);
        neuro = findViewById(R.id.edukasiNeuro);
        alergi = findViewById(R.id.edukasiAlergi);
        diagnosa = findViewById(R.id.id_diagnosa);

        diagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diagnosa = new Intent(EducationActivity.this, DiagnosaActivity.class);
                startActivity(diagnosa);
            }
        });

        atopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atopic  = new Intent(EducationActivity.this, AtopicActivity.class);
                startActivity(atopic);
            }
        });

        kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kontak = new Intent(EducationActivity.this, KontakActivity.class);
                startActivity(kontak);
            }
        });

        alergi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alergi = new Intent(EducationActivity.this, AlergiActivity.class);
                startActivity(alergi);
            }
        });

        neuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent neuro  = new Intent(EducationActivity.this, NeuroActivity.class);
                startActivity(neuro);
            }
        });
    }
}
