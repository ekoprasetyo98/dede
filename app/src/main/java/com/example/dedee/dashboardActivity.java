package com.example.dedee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class dashboardActivity extends AppCompatActivity {
    private RelativeLayout diagnosa;
    private RelativeLayout profil;
    private RelativeLayout education;
    private RelativeLayout history;
    Button cek;
    private  static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

//        int images[]= {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide5};
//        viewFlipper = findViewById(R.id.v_fliper);

//        looping for carousel
//        for (int image:images){
//            flipperImages(image);
//        }


        diagnosa = findViewById(R.id.id_diagnosa);
        cek = findViewById(R.id.deskripsicek);
        profil = findViewById(R.id.id_profil);
        education = findViewById(R.id.edukasi);
        history = findViewById(R.id.id_history);
//        riwayat = findViewById(R.id.id_riwayat);

        /*set button diagnosa*/
        diagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboardActivity.this, DiagnosaActivity.class);
                startActivity(intent);


            }
        });

        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboardActivity.this, DiagnosaActivity.class);
                startActivity(intent);
            }
        });


        /*set button profil*/
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profilIntent = new Intent(dashboardActivity.this, profilActivity.class);
                startActivity(profilIntent);
            }
        });


        /*set button edukasi*/
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edukasiIntent = new Intent(dashboardActivity.this, EducationActivity.class);
                startActivity(edukasiIntent);
            }
        });

        /*set button menuju halaman website admin*/
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder peringatan = new AlertDialog.Builder(dashboardActivity.this)
                        .setTitle("Peringatan!")
                        .setMessage("Apakah anda seorang admin? Anda harus memiliki username dan password admin!")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse("https://admindede.000webhostapp.com/"));
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent kembali  = new Intent(dashboardActivity.this, dashboardActivity.class);
                            }
                        });
                peringatan.show();

            }
        });
    }


    /*set animation for carousel image*/
//    public void flipperImages(int image){
//        ImageView imageView = new ImageView(this);
//        imageView.setBackgroundResource(image);
//
//        viewFlipper.addView(imageView);
//        viewFlipper.setFlipInterval(4000);
//        viewFlipper.setAutoStart(true);
//
//
//        //animation
//        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
//        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
//    }

    public void onBackPressed(){
        if (mBackPressed + TIME_INTERVAL>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            Toast.makeText(getBaseContext(),"Tekan sekali lagi untuk keluar",Toast.LENGTH_SHORT)
                    .show();
            mBackPressed = System.currentTimeMillis();
        }
//        AlertDialog.Builder builder= new AlertDialog.Builder(this);
//        builder.setCancelable(false);
//        builder.setMessage("Apakah anda ingin keluar?")
//                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        finish();
////                        System.exit(0);
//                    }
//                });
//        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int i) {
//                dialog.cancel();
//            }
//        });
//        AlertDialog alert = builder.create();
//        alert.show();
    }
}
