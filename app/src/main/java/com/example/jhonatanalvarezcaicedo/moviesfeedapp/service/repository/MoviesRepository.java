package com.example.jhonatanalvarezcaicedo.moviesfeedapp.service.repository;

import android.content.Context;

import com.example.jhonatanalvarezcaicedo.moviesfeedapp.service.APIService;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.service.BaseService;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.service.RetrofitClient;

/**
 * Created by jhonatanalvarezcaicedo on 8/06/17.
 */

public class MoviesRepository extends BaseService<APIService> {
    private static APIService apiService;
    private Context context;

    public MoviesRepository(Context context) {
        setRetrofitClient(new RetrofitClient<APIService>());
        apiService = getRetrofitClient().getInstance(APIService.class);
        this.context = context;
    }

    public APIService getApiService() {
        return apiService;
    }
}
