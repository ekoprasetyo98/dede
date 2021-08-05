package com.example.dedee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registrasiActivity extends AppCompatActivity {

    Button daftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        daftar = findViewById(R.id.daftarUser);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftarBaru = new Intent(registrasiActivity.this, dashboardActivity.class);
                startActivity(daftarBaru);
            }
        });
    }
}
