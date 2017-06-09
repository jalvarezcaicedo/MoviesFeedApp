package com.example.jhonatanalvarezcaicedo.moviesfeedapp.service;

import com.example.jhonatanalvarezcaicedo.moviesfeedapp.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jhonatanalvarezcaicedo on 8/06/17.
 */

public interface APIService {

    @GET("/3/movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("/3/movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("/3/movie/upcoming")
    Call<MoviesResponse> getUpcomingMovies(@Query("api_key") String apiKey);

}
