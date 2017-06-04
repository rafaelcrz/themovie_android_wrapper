package com.github.rafaelcrz.themovie_android_wrapper.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.github.rafaelcrz.themovie_android_wrapper.BuildConfig;
import com.github.rafaelcrz.themovie_android_wrapper.R;
import com.github.rafaelcrz.themovie_android_wrapper.adapter.ListMovieAdapter;
import com.github.rafaelcrz.themovie_android_wrapper.adapter.RecyclerViewOnClickListenerHack;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.api.TheMovieApi;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.api.TheMovieApiListener;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.Movie;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.MovieCatalog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private RecyclerView mRecyclerView;

    private static final String API_KEY = "YOUR_API_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerMovies);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        List<Movie> movieList = new ArrayList<>();
        final ListMovieAdapter movieAdapter = new ListMovieAdapter(this, movieList);


        TheMovieApi theMovieApi = new TheMovieApi(this, API_KEY);
        theMovieApi.setPage(1);
        //theMovieApi.setLanguage("es");

        theMovieApi.getMovieCatalog(TheMovieApi.NOW_PLAYING, new TheMovieApiListener<MovieCatalog>() {
            @Override
            public void onResponse(Call<MovieCatalog> call, Response<MovieCatalog> movieResultResponse) {

                if (movieResultResponse.isSuccessful()) {
                    final MovieCatalog movieCatalogs = movieResultResponse.body();
                    for (Movie movie : movieCatalogs.getResults()) {
                        movieAdapter.addItem(movie, movieAdapter.getItemCount() - 1);
                    }

                    mRecyclerView.setAdapter(movieAdapter);
                    movieAdapter.setRecyclerViewOnClickListenerHack(new RecyclerViewOnClickListenerHack() {
                        @Override
                        public void onClickListener(View view, int position) {
                            Movie movie = movieCatalogs.getResults().get(position);
                            showMessage(movie.toString());
                        }
                    });
                } else {
                    if (movieResultResponse.code() == 401) {
                        showMessage("Invalid API key.");
                    } else {
                        showMessage("" + movieResultResponse.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieCatalog> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    private void showMessage(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_LONG).show();
    }
}
