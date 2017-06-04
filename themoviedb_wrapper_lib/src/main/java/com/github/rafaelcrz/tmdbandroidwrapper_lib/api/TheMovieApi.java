package com.github.rafaelcrz.tmdbandroidwrapper_lib.api;

import android.content.Context;
import android.util.Log;

import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.MovieCatalog;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.MovieDetail;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.TrailerCatalog;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael Felipe on 26/05/2017.
 * <p>
 * TheMoviedb API client.
 */

public class TheMovieApi implements TheMovieParams {

    public static final String NOW_PLAYING = "movie/now_playing";
    public static final String POPULAR = "movie/popular";
    public static final String TOP_RATED = "movie/top_rated";

    private TheMovieApplication movieApplication; //The aplication has a RetrofitService global
    private TheMovieService theMovieService; //The service with all calls methods

    private Map<String, String> mParams;

    private final String LANGUAGE = "language";
    private final String PAGE = "page";
    private final String APPEND_TO_RESPONSE = "append_to_response";
    private final String API_KEY = "api_key";

    private String tmdb_apikey; //TheMoviedb api key. The requests needs an api key
    private String language; //Divicelengugage default
    private int page = 1;

    /**
     * @param context aplication context
     * @param apiKey  themoviedb apikey
     */
    public TheMovieApi(Context context, String apiKey) {
        this.tmdb_apikey = apiKey;
        this.movieApplication = (TheMovieApplication) context.getApplicationContext();
        this.theMovieService = movieApplication.getTheMovieService();
        Locale locale = Locale.getDefault();
        this.language = locale.toString().replace("_", "-");
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int getPage() {
        return this.page;
    }


    /**
     * This method return a MovieCatalogResponse. TheMoviedb Api return a Json with all movie, but the content
     * depends of the url endpoint.
     *
     * @param url      The url endpoint. Example: for movies playing now {/movie/now_playing}
     * @param listener TheMovieApiListener for get the onResponse and onFailure
     */
    public void getMovieCatalog(String url, final TheMovieApiListener<MovieCatalog> listener) {

        mParams = new HashMap<>();
        mParams.put(API_KEY, this.tmdb_apikey);
        mParams.put(LANGUAGE, this.language);
        mParams.put(PAGE, String.valueOf(this.page));

        Call<MovieCatalog> movieCatalogCall = theMovieService.getMovieCatalog(url, mParams);

        movieCatalogCall.enqueue(new Callback<MovieCatalog>() {
            @Override
            public void onResponse(Call<MovieCatalog> call, Response<MovieCatalog> response) {
                listener.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<MovieCatalog> call, Throwable t) {
                listener.onFailure(call, t);
            }
        });
    }

    /**
     * This method request a movie detail. All espefic information about a movie.
     *
     * @param movie_id           Movie id
     * @param append_to_response (video; images; video,images;) This makes it possible to make sub requests within the same
     *                           nameespace in a single Http request.
     * @param listener           TheMovieApilistener for get the response and failure
     */
    public void getDatailMovie(int movie_id, String append_to_response, final TheMovieApiListener<MovieDetail> listener) {

        mParams = new HashMap<>();
        mParams.put(API_KEY, this.tmdb_apikey);
        mParams.put(LANGUAGE, this.language);
        mParams.put(APPEND_TO_RESPONSE, append_to_response);

        Call<MovieDetail> movieDatailCall = theMovieService.getDetailMovie(movie_id, mParams);
        movieDatailCall.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                listener.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                listener.onFailure(call, t);
            }
        });
    }

    /**
     * Get all videos of a movie (clips and official trailer)
     *
     * @param movie_id
     * @param listener
     */
    public void getVideosFromMovie(int movie_id, final TheMovieApiListener<TrailerCatalog> listener) {
        mParams = new HashMap<>();
        mParams.put(API_KEY, this.tmdb_apikey);
        mParams.put(LANGUAGE, this.language);

        Call<TrailerCatalog> movieVideoCall = theMovieService.getMovieTrailer(movie_id, mParams);
        movieVideoCall.enqueue(new Callback<TrailerCatalog>() {
            @Override
            public void onResponse(Call<TrailerCatalog> call, Response<TrailerCatalog> response) {
                listener.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<TrailerCatalog> call, Throwable t) {
                listener.onFailure(call, t);
            }
        });

    }


}
