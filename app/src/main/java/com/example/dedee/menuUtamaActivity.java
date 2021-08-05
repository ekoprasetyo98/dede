package com.example.dedee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class menuUtamaActivity extends AppCompatActivity {
    RelativeLayout registrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        registrasi = findViewById(R.id.id_regitrasi);
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRegistrasi = new Intent(menuUtamaActivity.this, registrasiActivity.class);
                startActivity(viewRegistrasi);
            }
        });
    }
}
