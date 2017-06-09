package com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.jhonatanalvarezcaicedo.moviesfeedapp.BuildConfig;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.R;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.model.Movie;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.model.MoviesResponse;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.service.repository.MoviesRepository;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.adapter.MoviesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularFragment extends Fragment {
    private RecyclerView recyclerView;
    private MoviesRepository moviesRepository;
    private List<Movie> movieList;
    private MoviesAdapter moviesAdapter;


    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_popular);
        //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        movieList = new ArrayList<>();
        moviesAdapter = new MoviesAdapter(movieList, R.layout.item_movie, getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(moviesAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callData();
            }
        });

        moviesRepository = new MoviesRepository(getActivity());

        callData();
    }

    public void callData() {
        Call<MoviesResponse> call = moviesRepository.getApiService().getPopularMovies(BuildConfig.CONTEXT);

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response != null) {
                    moviesAdapter.setMovieList(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.e(getClass().getSimpleName(), t.toString());
            }
        });
        moviesAdapter.notifyDataSetChanged();

    }


}
