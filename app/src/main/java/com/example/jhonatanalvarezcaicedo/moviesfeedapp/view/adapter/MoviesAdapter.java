package com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.BuildConfig;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.R;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.model.Movie;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.activity.VideoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhonatanalvarezcaicedo on 8/06/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private LayoutInflater inflater;
    private List<Movie> movieList;
    private Context context;
    private int rowLayout;

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        movieList = new ArrayList<>();
        movieList = movies;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.rowLayout = rowLayout;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_movie, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movieList.get(position).getTitle());
        holder.data.setText(movieList.get(position).getReleaseDate());
        holder.rating.setText(movieList.get(position).getVoteAverage().toString());
        Glide.with(context)
                .load(BuildConfig.IMAGE_BASE + movieList.get(position).getPosterPath())
                .placeholder(R.color.colorAccent)
                .into(holder.poster);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("desc", BuildConfig.IMAGE_BASE + movieList.get(position).getPosterPath());
                intent.putExtra("desc", movieList.get(position).getOverview());
                intent.putExtra("adult", movieList.get(position).isAdult());
                intent.putExtra("backdrop", movieList.get(position).getOverview());
                context.startActivity(intent);*/
            }
        });
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (movieList == null) ? 0 : movieList.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        TextView movieTitle;
        TextView data;
        TextView rating;
        ImageView poster;

        MovieViewHolder(View itemView) {
            super(itemView);
            container = (RelativeLayout) itemView.findViewById(R.id.movies_container);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            data = (TextView) itemView.findViewById(R.id.subtitle);
            rating = (TextView) itemView.findViewById(R.id.rating);
            poster = (ImageView) itemView.findViewById(R.id.poster);
        }
    }
}
