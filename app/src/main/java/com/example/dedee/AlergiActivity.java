package com.example.dedee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AlergiActivity extends AppCompatActivity {
    LinearLayout penjelasan, gejala, pengobatan, pencegahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alergi);
        getSupportActionBar().hide();

        penjelasan = findViewById(R.id.alertPenjelasan);
        gejala = findViewById(R.id.alertGejala);
        pencegahan = findViewById(R.id.alertPencegahan);
        pengobatan = findViewById(R.id.alertPengobatan);

        String despengertian = "Dermatitis kontak alergi terjadi ketika kulit mengalami reaksi alergi, setelah kontak dengan zat tertentu (alergen), sehingga menyebabkan tubuh melepaskan zat kimia yang memicu gatal dan iritasi pada kulit. Zat pemicunya, antara lain perhiasan seperti nikel atau emas, sarung tangan latex, pewangi atau bahan kimia pada produk kecantikan, serta tumbuhan poison oak atau poison ivy.";
        String desgejala = "- Kulit kering.\n" +
                "- Kulit melepuh.\n" +
                "- Kemerahan pada kulit.\n" +
                "- Kulit tampak gelap.\n" +
                "- Kulit terasa perih.\n" +
                "- Gatal yang parah.\n" +
                "- Sensitif terhadap cahaya matahari.";
        String despencegahan = "- Gunakan produk berlabel hypoallergenic atau yang tidak mengandung parfum maupun pewangi.\n" +
                "- Hindari penggunaan sarung tangan lateks jika memiliki riwayat alergi lateks dan gunakan sarung tangan vinyl.\n" +
                "- Gunakan pakaian berlengan panjang dan celana panjang saat mendaki di alam.\n" +
                "- Gunakan krim pada tangan untuk menghindari kulit kering.";
        String despengobatan = "- Menghindari paparan zat yang menjadi penyebab iritasi atau alergi di kulit.\n" +
                "- Berhenti menggunakan produk yang mengandung zat pemicu iritasi atau alergi.\n" +
                "- Menggunakan pelembap kulit.\n" +
                "- Mengompres area dermatitis kontak dengan kompres dingin.\n" +
                "- Menghindari garukan pada area kulit yang mengalami dermatitis kontak.\n" +
                "- Melindungi tangan dengan menggunakan sarung tangan jika diperlukan.\n" +
                "- Mengkonsumsi obat-obatan kortikosteroid, baik dalam bentu salep maupun tablet.\n" +
                "- Terapi imunosupresan, yaitu pemberian obat-obatan yang menekan sistem kekebalan tubuh, untuk mengurangi peradangan.\n" +
                "- Fototerapi,. Tindakan medis ini dilakukan dengan menggunakan paparan sinar UV untuk membantu mengembalikan tampilan kulit yang terkena dermatitis kontak.";


        penjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlergiActivity.this)
                        .setTitle("Penjelasan : ")
                        .setMessage(""+despengertian)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AlergiActivity.this, AlergiActivity.class);
                            }
                        });
                builder.show();

            }

        });

        gejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderGejala = new AlertDialog.Builder(AlergiActivity.this)
                        .setTitle("Gejala :")
                        .setMessage("" +desgejala)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AlergiActivity.this, AlergiActivity.class);
                            }
                        });
                builderGejala.show();
            }
        });

        pencegahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderPencegahan = new AlertDialog.Builder(AlergiActivity.this)
                        .setTitle("Pencegahan : ")
                        .setMessage("" +despencegahan)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AlergiActivity.this, AlergiActivity.class);
                            }
                        });
                builderPencegahan.show();
            }
        });

        pengobatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderPengobatan = new AlertDialog.Builder(AlergiActivity.this)
                        .setTitle("Pengobatan : ")
                        .setMessage("" +despengobatan)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(AlergiActivity.this, AlergiActivity.class);
                            }
                        });
                builderPengobatan.show();
            }
        });



    }
}
