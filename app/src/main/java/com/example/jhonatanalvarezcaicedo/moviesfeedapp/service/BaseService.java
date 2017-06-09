package com.example.jhonatanalvarezcaicedo.moviesfeedapp.service;

/**
 * Created by jhonatanalvarezcaicedo on 8/06/17.
 */

public class BaseService<T> {

    private RetrofitClient retrofitClient;

    public RetrofitClient<T> getRetrofitClient() {
        return retrofitClient;
    }

    public void setRetrofitClient(RetrofitClient<T> retrofitClient) {
        this.retrofitClient = retrofitClient;
    }
}