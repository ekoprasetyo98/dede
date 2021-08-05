package com.example.dedee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NeuroActivity extends AppCompatActivity {
    LinearLayout penjelasan, gejala, pengobatan, pencegahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neuro);
        getSupportActionBar().hide();

        penjelasan = findViewById(R.id.alertPenjelasan);
        gejala = findViewById(R.id.alertGejala);
        pencegahan = findViewById(R.id.alertPencegahan);
        pengobatan = findViewById(R.id.alertPengobatan);

        String despengertian = "Penyakit neurodermatitis adalah penyakit kulit kronis yang ditandai dengan munculnya bercak putih pada bagian kulit yang terasa sangat gatal. Rasa gatal yang diakibatkan penyakit neurodermatitis terasa semakin gatal ketika pengidap menggaruk kulit. Umumnya, bercak putih pada kulit muncul di beberapa area bagian tubuh seperti leher, pergelangan tangan, lengan, paha, dan pergelangan kaki.";
        String desgejala = "- Rasa gatal yang ditimbulkan dari penyakit neurodermatitis semakin terasa ketika pengidap sedang beristirahat atau tidak beraktivitas.\n" +
                "- Bercak dan gatal yang terjadi pada bagian kulit kepala dapat menyebabkan kerontokan rambut yang berujung kebotakan pada area tertentu.\n" +
                "- Bagian kulit yang terasa gatal bertekstur kasar atau bersisik.\n" +
                "- Bercak atau bagian yang gatal terlihat lebih menonjol dan merah dibandingkan bagian tubuh yang lainnya.";
        String despencegahan = "- ";
        String despengobatan = "- Krim anti peradangan. Dokter akan meresepkan krim kortikosteroid untuk mengurangi peradangan dan rasa gatal pada kulit.\n" +
                "- Obat antihistamin. .\n" +
                "- Kortikosteroid suntik. Dokter dapat menyuntikkan kortikosteroid langsung pada kulit yang terkena neurodermatitis. Prosedur ini berguna untuk membantu proses penyembuhan.";

        penjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NeuroActivity.this)
                        .setTitle("Penjelasan : ")
                        .setMessage(despengertian)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(NeuroActivity.this, NeuroActivity.class);
                            }
                        });
                builder.show();

            }

        });

        gejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderGejala = new AlertDialog.Builder(NeuroActivity.this)
                        .setTitle("Gejala :")
                        .setMessage(desgejala)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(NeuroActivity.this, NeuroActivity.class);
                            }
                        });
                builderGejala.show();
            }
        });

        pencegahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderPencegahan = new AlertDialog.Builder(NeuroActivity.this)
                        .setTitle("Pencegahan : ")
                        .setMessage(despencegahan)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(NeuroActivity.this, NeuroActivity.class);
                            }
                        });
                builderPencegahan.show();
            }
        });

        pengobatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderPengobatan = new AlertDialog.Builder(NeuroActivity.this)
                        .setTitle("Pengobatan : ")
                        .setMessage(despengobatan)
                        .setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali = new Intent(NeuroActivity.this, NeuroActivity.class);
                            }
                        });
                builderPengobatan.show();
            }
        });


    }
}
