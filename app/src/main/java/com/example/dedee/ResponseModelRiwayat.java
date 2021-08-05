package com.example.dedee;

import com.google.gson.annotations.SerializedName;

public class ResponseModelRiwayat {
    @SerializedName("Response_code")
    private String str_code;
    public String getResponseCode(){
        return str_code;
    }

    public void setResponseCode(String Response_code){
        str_code = Response_code;
    }

    @SerializedName("Response_msg")
    private String str_msg;
    public String getResponseMsg(){
        return str_msg;
    }

    public void setResponseMsg(String Response_msg){
        str_code = Response_msg;
    }

    @SerializedName("nama")
    private String nama;

    @SerializedName("usia")
    private String usia;

    @SerializedName("jenkel")
    private String jenkel;

    @SerializedName("hasil")
    private String hasil;

    @SerializedName("kesimpulan")
    private String kesimpulan;


    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getUsia(){
        return usia;
    }

    public void setUsia(String usia){
        this.nama = usia;
    }

    public String getJenkel(){
        return jenkel;
    }

    public void setJenkel(String jenkel){
        this.jenkel = jenkel;
    }

    public String getHasil(){
        return hasil;
    }

    public void setHasil(String hasil){
        this.hasil = hasil;
    }

    public String getKesimpulan(){
        return kesimpulan;
    }

    public void setKesimpulan(String kesimpulan){
        this.hasil = kesimpulan;
    }
}
