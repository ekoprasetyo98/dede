package com.example.dedee;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("tampil.php")
    Call<ResponseModelRiwayat> getRiwayat();

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseModelRiwayat> proses
                        (@Field("nama") String nama,
                       @Field("usia") String usia,
                       @Field("jenkel") String jenkel,
                       @Field("hasil") String hasil,
                        @Field("kesimpulan") String kesimpulan);


}
