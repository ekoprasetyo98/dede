package com.example.dedee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiagnosaActivity extends AppCompatActivity {

    /*set awal variabel layout*/
    ViewFlipper viewFlipper;
    CheckBox g01, g02, g03, g04, g05, g06,
    g07, g08, g09, g10, g11, g12, g13, g14,g15,g16,g17,g18,g19,g20,g21,g22,g23,g24,g25,g26;
    Button prosess;
    ImageView imageAlert;
    EditText edNama, edUsia, edJenkel;
    TextView outputNamaPenyakit;
    RadioGroup radioGroupJK;

    /*memberi type float pada masing" fakta dari user(CFuser) dan pakar (CFpakar)*/
    double CFpakar1, CFpakar2,CFpakar3,CFpakar4,CFpakar5,CFpakar6,CFpakar7,CFpakar8,CFpakar9,CFpakar10,CFpakar11,CFpakar12,CFpakar13,CFpakar14,CFpakar15,CFpakar16,CFpakar17,CFpakar18,CFpakar19,CFpakar20,CFpakar21,CFpakar22,CFpakar23,CFpakar24,CFpakar25,CFpakar26;
    double CFuser1, CFuser2,CFuser3,CFuser4,CFuser5,CFuser6,CFuser7,CFuser8,CFuser9,CFuser10,CFuser11,CFuser12,CFuser13,CFuser14,CFuser15,CFuser16,CFuser17,CFuser18,CFuser19,CFuser20,CFuser21,CFuser22,CFuser23;

    /*memberi type float pada fakta atau gejala*/
    double CFfakta1,CFfakta2,CFfakta3,CFfakta4,CFfakta5,CFfakta6,CFfakta7,CFfakta8,CFfakta9,CFfakta10,CFfakta11,CFfakta12,CFfakta13,CFfakta14,CFfakta15,CFfakta16,CFfakta17,CFfakta18,CFfakta19,CFfakta20,CFfakta21,CFfakta22,CFfakta23,CFfakta24,CFfakta25,CFfakta26;

    /*memberi type float pada total*/
    double CFtotal1,CFtotal2,CFtotal3,CFtotal4,CFtotal5,CFtotal6,CFtotal7;

    /*memberi type float pada penyakit*/
    double CFatopic,CFiritan,CFneuro,CFalergi,CFherves;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);

        /*looping carousel*/
        int images[]= {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide5};
        viewFlipper = findViewById(R.id.v_fliper);
        for (int image:images){
            flipperImages(image);
        }


//       SET ID
        /*
        *
        * */
        /*set id untuk input form identitas*/
        edNama = findViewById(R.id.nama);
        edUsia = findViewById(R.id.usia);
        /*edJenkel = findViewById(R.id.jenkel);*/




        /*set id untuk checkbox gejala*/
        g01 =(CheckBox)findViewById(R.id.g01);
        g02 = (CheckBox) findViewById(R.id.g02);
        g03 = (CheckBox) findViewById(R.id.g03);
        g04 = (CheckBox) findViewById(R.id.g04);
        g05 = (CheckBox) findViewById(R.id.g05);
        g06 = (CheckBox) findViewById(R.id.g06);
        g07 = (CheckBox) findViewById(R.id.g07);
        g08 = (CheckBox) findViewById(R.id.g08);
        g09 = (CheckBox) findViewById(R.id.g09);
        g10  = (CheckBox) findViewById(R.id.g10);
        g11 = (CheckBox) findViewById(R.id.g11);
        g12 = (CheckBox)findViewById(R.id.g12);
        g13 = (CheckBox)findViewById(R.id.g13);
        g14 = (CheckBox)findViewById(R.id.g14);
        g15 = (CheckBox)findViewById(R.id.g15);
        g16 = (CheckBox)findViewById(R.id.g16);
        g17  = (CheckBox) findViewById(R.id.g17);
        g18 = (CheckBox) findViewById(R.id.g18);
        g19 = (CheckBox)findViewById(R.id.g19);
        g20 = (CheckBox)findViewById(R.id.g20);
        g21 = (CheckBox)findViewById(R.id.g21);
        g22 = (CheckBox)findViewById(R.id.g22);
        g23 = (CheckBox)findViewById(R.id.g23);
        g24 = (CheckBox)findViewById(R.id.g24);
        g25 = (CheckBox)findViewById(R.id.g25);
        g26 = (CheckBox)findViewById(R.id.g26);

        radioGroupJK = findViewById(R.id.jenkel);

        /*set id untuk image carousel*/
        imageAlert = (ImageView) findViewById(R.id.alertImage);

        /*set id untuk button proses*/
        prosess = (Button) findViewById(R.id.button);

        /*set id untuk menampilkan nama penyakit*/
        outputNamaPenyakit = (TextView) findViewById(R.id.hasil);
        outputNamaPenyakit.setText("");
        /*
        *
        * */


        /*memproses ketika button diklik*/
        prosess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*melakukan pengecekan apabila form identitas kosong*/
                if (edNama.length()==0 || edUsia.length()==0){
                    AlertDialog.Builder alertt = new AlertDialog.Builder(DiagnosaActivity.this, R.style.CustomDialog);
                    LayoutInflater factory = LayoutInflater.from(DiagnosaActivity.this);
                    final View view = factory.inflate(R.layout.alert, null);
                    alertt.setView(view);
//                            .setMessage("Identitas harus diisi semua");
                    alertt.show();
                }
                /*apbila form identitas sudah terisi*/

                else{

                String JenisDermatitis = "Hasil Diagnosa : ";
                String name = edNama.getText().toString();
                String usia = edUsia.getText().toString();
                String jenkel;

                switch (radioGroupJK.getCheckedRadioButtonId()) {
                    case R.id.rbLaki:
                        jenkel = "L";
                        break;
                    case R.id.rbPerempuan:
                        jenkel = "P";
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + radioGroupJK.getCheckedRadioButtonId());
                }

                Log.d("Jenis Kelamin", jenkel);

                String hasil = outputNamaPenyakit.getText().toString();

                CFfakta1=0;
                CFfakta2=0;
                CFfakta3=0;
                CFfakta4=0;
                CFfakta5=0;
                CFfakta6=0;
                CFfakta7=0;
                CFfakta8=0;
                CFfakta9=0;
                CFfakta10=0;
                CFfakta11=0;
                CFfakta12=0;
                CFfakta13=0;
                CFfakta14=0;
                CFfakta15=0;
                CFfakta16=0;
                CFfakta17=0;
                CFfakta18=0;
                CFfakta19=0;
                CFfakta20=0;
                CFfakta21=0;
                CFfakta22=0;
                CFfakta23=0;
                CFfakta24=0;
                CFfakta25=0;
                CFfakta26=0;

                // COMBINASI
                CFtotal1=0;
                CFtotal2=0;
                CFtotal3=0;
                CFtotal4=0;
                CFtotal5=0;
                CFtotal6 = 0;
                CFtotal7 = 0;

                // penyakit
                CFalergi = 0;
                CFatopic = 0;
                CFiritan = 0;
                CFherves = 0;
                CFneuro = 0;

                /*proses logika backward chaining IF THEN ELSE*/
                CFpakar1 = 0;
                if (g01.isChecked()){
                    CFpakar1 = CFpakar1+0.3;
                    CFfakta1 = CFpakar1*0.2;

                }else{
                    kosong();
                }

                CFpakar2 = 0;
                if (g02.isChecked()){
                    CFpakar2 = CFpakar2+0.3;
                    CFfakta2 = CFpakar2*0.6;

                }else{
                    kosong();
                }

                CFpakar3 = 0;
                if (g03.isChecked()){
                    CFpakar3 = CFpakar3+0.5;
                    CFfakta3 = CFpakar3*0.2;

                }else{
                    kosong();
                }

                CFpakar4 = 0;
                if (g04.isChecked()){
                    CFpakar4 = CFpakar4+0.5;
                    CFfakta4 = CFpakar4*0.4;

                }else{
                    kosong();
                }

                CFpakar5 = 0;
                if (g05.isChecked()){
                    CFpakar5 = CFpakar5+0.5;
                    CFfakta5 = CFpakar5*0.6;

                }else{
                    kosong();
                }

                CFpakar6 = 0;
                if (g06.isChecked()){
                    CFpakar6 = CFpakar6+0.7;
                    CFfakta6 = CFpakar6*0.8;

                }else{
                    kosong();
                }

                CFpakar7 = 0;
                if (g07.isChecked()){
                    CFpakar7 = CFpakar7+0.3;
                    CFfakta7 = CFpakar7*0.4;

                }else{
                    kosong();
                }

                CFpakar8 = 0;
                if (g08.isChecked()){
                    CFpakar8 = CFpakar8+0.3;
                    CFfakta8 = CFpakar8*0.6;

                }else{
                    kosong();
                }

                CFpakar9 = 0;
                if (g09.isChecked()){
                    CFpakar9 = CFpakar9+0.7;
                    CFfakta9 = CFpakar9*0.8;

                }else{
                    kosong();
                }

                CFpakar10 = 0;
                if (g10.isChecked()){
                    CFpakar10 = CFpakar10+0.5;
                    CFfakta10 = CFpakar10*0.4;

                }else{
                    kosong();
                }

                CFpakar11 = 0;
                if (g11.isChecked()){
                    CFpakar11 = CFpakar11+0.7;
                    CFfakta2 = CFpakar11*0.4;

                }else{
                    kosong();
                }

                CFpakar12 = 0;
                if (g12.isChecked()){
                    CFpakar12 = CFpakar12+0.7;
                    CFfakta12 = CFpakar12*0.4;

                }else{
                    kosong();
                }

                CFpakar13 = 0;
                if (g13.isChecked()){
                    CFpakar13 = CFpakar13+0.3;
                    CFfakta13 = CFpakar13*0.4;

                }else{
                    kosong();
                }

                CFpakar14 = 0;
                if (g14.isChecked()){
                    CFpakar14 = CFpakar14+0.7;
                    CFfakta14 = CFpakar14*0.4;

                }else{
                    kosong();
                }

                CFpakar15 = 0;
                if (g15.isChecked()){
                    CFpakar15 = CFpakar15+0.5;
                    CFfakta15 = CFpakar15*0.6;

                }else{
                    kosong();
                }

                CFpakar16 = 0;
                if (g16.isChecked()){
                    CFpakar16 = CFpakar16+0.3;
                    CFfakta16 = CFpakar16*0.4;

                }else{
                    kosong();
                }

                CFpakar17 = 0;
                if (g17.isChecked()){
                    CFpakar17 = CFpakar17+0.7;
                    CFfakta17 = CFpakar17*0.6;

                }else{
                    kosong();
                }

                CFpakar18 = 0;
                if (g18.isChecked()){
                    CFpakar18 = CFpakar18+0.7;
                    CFfakta18 = CFpakar18*0.6;

                }else{
                    kosong();
                }

                CFpakar19 = 0;
                if (g19.isChecked()){
                    CFpakar19 = CFpakar19+0.3;
                    CFfakta19 = CFpakar19*0.4;

                }else{
                    kosong();
                }

                CFpakar20 = 0;
                if (g20.isChecked()){
                    CFpakar20 = CFpakar20+0.2;
                    CFfakta20 = CFpakar20*0.5;

                }else{
                    kosong();
                }

                CFpakar21 = 0;
                if (g21.isChecked()){
                    CFpakar21 = CFpakar21+0.7;
                    CFfakta21 = CFpakar21*0.4;

                }else{
                    kosong();
                }

                CFpakar22 = 0;
                if (g22.isChecked()){
                    CFpakar22 = CFpakar22+0.3;
                    CFfakta22 = CFpakar22*0.4;

                }else{
                    kosong();
                }

                CFpakar23 = 0;
                if (g23.isChecked()){
                    CFpakar23 = CFpakar23+0.7;
                    CFfakta23 = CFpakar23*0.6;

                }else{
                    kosong();
                }

                CFpakar24 = 0;
                if (g24.isChecked()){
                    CFpakar24 = CFpakar24+0.7;
                    CFfakta24 = CFpakar24*0.4;

                }else{
                    kosong();
                }

                CFpakar25 = 0;
                if (g25.isChecked()){
                    CFpakar25 = CFpakar25+0.3;
                    CFfakta25 = CFpakar25*0.4;

                }else{
                    kosong();
                }

                CFpakar26 = 0;
                if (g26.isChecked()){
                    CFpakar26 = CFpakar26+0.7;
                    CFfakta26 = CFpakar26*0.8;

                }else{
                    kosong();
                }


                /*perhitungan certainty faktor*/
                /*pengondisian untuk masing-masing penyakit*/


//    fakta fakta

//                dermatitis atopic
//                gejala = 1,2,3,4,5,6,13
                CFtotal1 = CFfakta1 + CFfakta2 * (1 - CFfakta1);
                CFtotal2 = CFtotal1 + CFfakta3 * (1-CFtotal1);
                CFtotal3 = CFtotal2 + CFfakta4 * (1-CFtotal2);
                CFtotal4 = CFtotal3 + CFfakta5 * (1-CFtotal3);
                CFtotal5 = CFtotal4 + CFfakta6 * (1-CFtotal4);
                CFtotal6 = CFtotal5 + CFfakta13 * (1-CFtotal5);
                CFatopic = CFtotal6 * 100;

//                dermatitis alergi
//                gejala = 2,7,8,9,10,11,12,22
                CFtotal1 = CFfakta2 + CFfakta7 * (1 - CFfakta2);
                CFtotal2 = CFtotal1 + CFfakta8 * (1-CFtotal1);
                CFtotal3 = CFtotal2 + CFfakta9 * (1-CFtotal2);
                CFtotal4 = CFtotal3 + CFfakta10 * (1-CFtotal3);
                CFtotal5 = CFtotal4 + CFfakta11 * (1-CFtotal4);
                CFtotal6 = CFtotal5 + CFfakta12 * (1-CFtotal5);
                CFtotal7 = CFtotal6 + CFfakta22 * (1-CFtotal6);
                CFalergi = CFtotal6 * 100;

//                dermatits iritan
//                gejala = 7,13,14,15,21,23
                CFtotal1 = CFfakta7 + CFfakta13 * (1 - CFfakta7);
                CFtotal2 = CFtotal1 + CFfakta14 * (1-CFtotal1);
                CFtotal3 = CFtotal2 + CFfakta15 * (1-CFtotal2);
                CFtotal4 = CFtotal3 + CFfakta21 * (1-CFtotal3);
                CFtotal5 = CFtotal4 + CFfakta23 * (1-CFtotal4);
                CFiritan = CFtotal5*100;

//                herves
//                gejala = 1,8,16,17,18,19,20
                CFtotal1 = CFfakta1 + CFfakta8 * (1 - CFfakta1);
                CFtotal2 = CFtotal1 + CFfakta16 * (1-CFtotal1);
                CFtotal3 = CFtotal2 + CFfakta17 * (1-CFtotal2);
                CFtotal4 = CFtotal3 + CFfakta18 * (1-CFtotal3);
                CFtotal5 = CFtotal4 + CFfakta19 * (1-CFtotal4);
                CFtotal6 = CFtotal5 + CFfakta20 * (1-CFtotal5);
                CFherves = CFtotal6*100;

//                neurodermatitis
//                gejala 1,2,16,24,25,26
                CFtotal1 = CFfakta1 + CFfakta2 * (1 - CFfakta1);
                CFtotal2 = CFtotal1 + CFfakta16 * (1-CFtotal1);
                CFtotal3 = CFtotal2 + CFfakta24 * (1-CFtotal2);
                CFtotal4 = CFtotal3 + CFfakta25 * (1-CFtotal3);
                CFtotal5 = CFtotal4 + CFfakta26 * (1-CFtotal4);
                CFneuro = CFtotal5 *100;

                /*rule saran mengikuti nilai dari yang terbesar*/
                String saran = "Saran : ";
                String penjelasanAtopic = "\n- Memakai pakaian halus."+"\n- Hindari bahan seperti deterjen, sabun."+"\n- Menjaga suhu ruangan";
                String penjelasanIritan = "\n- Berhenti atau hindari menggunakan zat penyebab iritan."+"\n- Menggunakan pelindung ketika menggunakan zat tersebut."+"\n- Mengkonsumsi obat-obatan yang mengandung kortikosteroid, baik dalam bentuk salep maupun tablet."+"\n- Menggunakan pelembab kulit";
                String penjelasanAlergi = "\n- Hindari objek penyebab alergen."+"\n- Cermati produk yang bisa saja mengandung bahan penyebab alergi."+"\n- Apabila gejala semakin parah maka konsumsi obat-obatan yang mengandung kortikosteroid, baik dalam bentuk salep maupun tablet dengan resep dokter."+"\n- Menggunakan pelembab kulit";
                String penjelasanNeuro = "\n- Hindari pakaian yang terlalu ketat."+"\n- Mandi dengan air hangat."+"\n- Apabila gejala semakin parah gunakan krim anti peradangan, Obat antihistamin, Kortikosteroid sesuai dengan resep dokter";
                String penjelasanHerves = "\n- Konsumsi paracetamol atau ibuprofen sebagai obat pereda nyeri."+"\n- Kompres ruam kulit dengan air hangat atau atau air dingin."+"\n- Jaga area luka tetap kering dan bersih."+"\n- Gunakan pakaian dalam berbahan katun";
                if (CFatopic == 0 && CFherves == 0 && CFiritan == 0 && CFalergi == 0 && CFneuro == 0){
                    kosong();
                }else if (CFatopic >= CFalergi && CFatopic >= CFiritan && CFatopic >= CFherves && CFatopic >= CFneuro){
                    saran += penjelasanAtopic ;
                }else if (CFiritan >= CFatopic && CFiritan >= CFalergi &&CFiritan>=CFherves && CFiritan >= CFneuro){
                    saran += penjelasanIritan;
                }else if (CFalergi >= CFatopic && CFalergi >= CFiritan && CFalergi >= CFherves && CFalergi >= CFneuro) {
                    saran += penjelasanAlergi;
                }else if (CFherves >= CFalergi && CFherves >= CFiritan && CFherves >= CFatopic && CFherves >= CFneuro) {
                    saran += penjelasanHerves;
                }else if (CFneuro >= CFalergi && CFneuro >= CFiritan && CFneuro >= CFatopic && CFneuro >= CFherves){
                    saran += penjelasanNeuro;
                }

//                mengubah nilai
                DecimalFormat penyakit = new DecimalFormat("#.##");

//                menggabungkan nilai decimal dengan hasil dari CF
                String alergi = String.valueOf(penyakit.format(CFalergi))+"%";
                String atopic = String.valueOf(penyakit.format(CFatopic))+"%";
                String iritan = String.valueOf(penyakit.format(CFiritan))+"%";
                String herves = String.valueOf(penyakit.format(CFherves))+"%";
                String neuro = String.valueOf(penyakit.format(CFneuro))+"%";

                Log.d("alergi", alergi);
                String hasilDiagnosa = "Dermatitis Kontak Alergi : "+alergi+" Dermatitis Atopic : "+atopic+" Dermatitis Kontak Iritan : "+iritan+" Herves : "+herves+" Neurodermatitis : "+neuro;
                String kemungkinan = "";
                    if (CFatopic == 0 && CFherves == 0 && CFiritan == 0 && CFalergi == 0 && CFneuro == 0){
                        kosong();
                    }else if (CFatopic >= CFalergi && CFatopic >= CFiritan && CFatopic >= CFherves && CFatopic >= CFneuro){
                        kemungkinan += "Dermatitis atopic";
                    }else if (CFiritan >= CFatopic && CFiritan >= CFalergi &&CFiritan>=CFherves && CFiritan >= CFneuro){
                        kemungkinan += "Dermatitis kontak iritan";
                    }else if (CFalergi >= CFatopic && CFalergi >= CFiritan && CFalergi >= CFherves && CFalergi >= CFneuro) {
                        kemungkinan += "Dermatitis kontak alergi";
                    }else if (CFherves >= CFalergi && CFherves >= CFiritan && CFherves >= CFatopic && CFherves >= CFneuro) {
                        kemungkinan += "Herves";
                    }else if (CFneuro >= CFalergi && CFneuro >= CFiritan && CFneuro >= CFatopic && CFneuro >= CFherves){
                        kemungkinan += "Neurodermatitis";
                    }

                /*end proses logika*/

                /*menampilkan nama penyakit*/
                AlertDialog.Builder builder = new AlertDialog.Builder(DiagnosaActivity.this)
                        .setTitle("Nama : "+name+" ("+usia+" Tahun)")
                        .setMessage("Hasil diagnosa : \n"
                                +"- Dermatitis Kontak Alergi : "+alergi+"\n"
                                +"- Dermatitis atopic : "+atopic+"\n"
                                +"- Dermatitis kontak iritan : "+iritan+"\n"
                                +"- Herves : "+herves+"\n"
                                +"- Neurodermatitis : "+neuro
                                +"\n"+"-----------------------------------------------"
                                +"\n\nKesimpulan : "+kemungkinan+"\n"+saran);

                builder.show();
                outputNamaPenyakit.setText(""+JenisDermatitis);

                try {
                    ApiService api = ApiConfig.getClient().create(ApiService.class);

                    final Call<ResponseModelRiwayat> getData = api.proses(name, usia, jenkel, hasilDiagnosa, kemungkinan);
                    getData.enqueue(new Callback<ResponseModelRiwayat>() {
                        @Override
                        public void onResponse(Call<ResponseModelRiwayat> call, Response<ResponseModelRiwayat> response) {
                            if (response.isSuccessful()){
                                Log.d("RETRO","RESPONSE : "+response.body().getResponseCode()+","+response.body().getResponseMsg());
                                edNama.setText("");
                                edUsia.setText("");
//                                edJenkel.setText("");
//                                outputNamaPenyakit.setText("");

                            }else{
                                switch (response.code()){
                                    case 404:
                                        Log.d("404","Not Found");
                                        break;
                                    case 500:
                                        Log.d("500","Server eror");
                                        break;
                                    default:
                                        Log.d("","Not found");

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseModelRiwayat> call, Throwable t) {
                            Log.d("RETRO","RESPONSE : Failed");
                            Log.d("Return :",t.toString());

                        }
                    });
                }
                catch (Exception e){
                    Log.e("Error",e.getMessage());
                }



            }
        update();
            }
        });


    }

    public void update(){
        g01.setChecked(false);
        g02.setChecked(false);
        g03.setChecked(false);
        g04.setChecked(false);
        g05.setChecked(false);
        g06.setChecked(false);
        g07.setChecked(false);
        g08.setChecked(false);
        g09.setChecked(false);
        g10.setChecked(false);
        g11.setChecked(false);
        g12.setChecked(false);
        g13.setChecked(false);
        g14.setChecked(false);
        g15.setChecked(false);
        g16.setChecked(false);
        g17.setChecked(false);
        g18.setChecked(false);
        g19.setChecked(false);
        g20.setChecked(false);
        g21.setChecked(false);
        g22.setChecked(false);
        g23.setChecked(false);
        g24.setChecked(false);
        g25.setChecked(false);
        g26.setChecked(false);


    }

    public void kosong(){
        CFpakar1=0;
        CFpakar2=0;
        CFpakar3=0;
        CFpakar4=0;
        CFpakar5=0;
        CFpakar6=0;
        CFpakar7=0;
        CFpakar8=0;
        CFpakar9=0;
        CFpakar10=0;
        CFpakar11=0;
        CFpakar12=0;
        CFpakar13=0;
        CFpakar14=0;
        CFpakar15=0;
        CFpakar16=0;
        CFpakar17=0;
        CFpakar18=0;
        CFpakar19=0;
        CFpakar20=0;
        CFpakar21=0;
        CFpakar22=0;
        CFpakar23=0;
        CFpakar24=0;
        CFpakar25=0;
        CFpakar26=0;

    }

    public void onCheckboxClicked123 (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str = "";

    }


    private void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);


        //animation
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }


}


