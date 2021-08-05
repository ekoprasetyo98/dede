package com.example.dedee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AtopicActivity extends AppCompatActivity {
    LinearLayout penjelasan, gejala, pengobatan, pencegahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atopic);
        getSupportActionBar().hide();

        penjelasan = findViewById(R.id.alertPenjelasan);
        gejala = findViewById(R.id.alertGejala);
        pencegahan = findViewById(R.id.alertPencegahan);
        pengobatan = findViewById(R.id.alertPengobatan);

        String despengertian = "Dermatitis atopik merupakan salah satu jenis dermatitis (eksim) yang terjadi akibat adanya peradangan pada kulit. Kondisi ini bisa disertai dengan kulit yang memerah, kering, dan pecah-pecah. Peradangan biasanya berlangsung lama, bahkan hingga bertahun-tahun.";
        String desgejala = "- Ruam yang menonjol dan mengeluarkan cairan.\n" +
                "- Kulit kering dan bersisik.\n" +
                "- Kulit di telapak tangan atau area bawah mata mengerut atau kusut.\n" +
                "- Kulit di sekitar mata lebih gelap.\n" +
                "- Gatal pada lipatan tubuh.\n" +
                "- Kulit pecah-pecah, terkelupas, hingga mengeluarkan darah.";
        String despencegahan = "- Bersihkan secara berkala perlengkapan tidur. Ganti seprai dan sarung bantal guling minimal 2 minggu sekali.\n" +
                "- Gunakan selimut saat tidur, khususnya jika tidak tahan dengan udara dingin.\n" +
                "- Bersihkan rumah secara rutin.";
        String despengobatan = "- Menggunakan sabun yang mengandung pelembab, pH 5,5–6, tidak mengandung pewarna dan pewangi.\n" +
                "- Mencegah bahan iritan saat mandi, seperti sabun antiseptik.\n"+
                "- Setelah mandi segera (dalam waktu 3 menit setelah mandi), oleskan pelembap keseluruh kulit kecuali kulit kepala.\n" +
                "- Cara aplikasi: menggunakan tangan, dioleskan tipis di seluruh permukaan kulit kecuali kulit kepala, apabila kulit terkena air atau bahan lain dalam waktu kurang dari 5 menit setelah pengolesan, prosedur diulang kembali.";

        penjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AtopicActivity.this)
                        .setTitle("Penjelasan : ")
                        .setMessage(despengertian)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AtopicActivity.this, AtopicActivity.class);
                            }
                        });
                builder.show();

            }

        });

        gejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderGejala = new AlertDialog.Builder(AtopicActivity.this)
                        .setTitle("Gejala :")
                        .setMessage(desgejala)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AtopicActivity.this, AtopicActivity.class);
                            }
                        });
                builderGejala.show();
            }
        });

        pencegahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderPencegahan = new AlertDialog.Builder(AtopicActivity.this)
                        .setTitle("Pencegahan : ")
                        .setMessage(despencegahan)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AtopicActivity.this, AtopicActivity.class);
                            }
                        });
                builderPencegahan.show();
            }
        });

        pengobatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderPengobatan = new AlertDialog.Builder(AtopicActivity.this)
                        .setTitle("Pengobatan : " )
                        .setMessage(despengobatan)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AtopicActivity.this, AtopicActivity.class);
                            }
                        });
                builderPengobatan.show();
            }
        });


    }
}
