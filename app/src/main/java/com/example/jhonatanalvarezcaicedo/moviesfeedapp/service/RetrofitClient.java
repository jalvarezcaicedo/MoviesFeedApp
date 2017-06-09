package com.example.jhonatanalvarezcaicedo.moviesfeedapp.service;

import com.example.jhonatanalvarezcaicedo.moviesfeedapp.BuildConfig;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.helper.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jalvarez on 29/12/2016.
 */

public class RetrofitClient<T> {
    private static Retrofit retrofit = null;

    public RetrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();


        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat(Util.DATE_FORMAT)
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    public T getInstance(Class<T> service) {
        return retrofit.create(service);
    }
}
