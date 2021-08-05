package com.example.dedee;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    static final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();
//
//    public static Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://192.168.43.57/koneksidede/")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
////
//    ApiService apiService = retrofit.create(ApiService.class);
//



    private static final String base_url = "https://admindede.000webhostapp.com/";
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

}
