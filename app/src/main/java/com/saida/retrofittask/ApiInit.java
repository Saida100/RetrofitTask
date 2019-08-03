package com.saida.retrofittask;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiInit {

    Retrofit retrofit;
    APIInterfaces apiInterfaces;


    public void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpLogging())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }


    public OkHttpClient httpLogging() {
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient=okHttpClient.newBuilder().addInterceptor(logging).build();
        return okHttpClient;

    }


    public APIInterfaces getClient() {
        if (apiInterfaces == null) {
            apiInterfaces = retrofit.create(APIInterfaces.class);
        }
        return apiInterfaces;

    }
}
