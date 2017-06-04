package com.github.rafaelcrz.tmdbandroidwrapper_lib.api;

import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.MovieCatalog;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.MovieDetail;
import com.github.rafaelcrz.tmdbandroidwrapper_lib.model.TrailerCatalog;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Rafael Felipe on 26/05/2017.
 * <p>
 * The Service for get all movies call
 */

interface TheMovieService {

    //Base url for api version 3
    String BASE_URL = "https://api.themoviedb.org/3/";

    /**
     * This call return a MovieCatalog. The Json response depends of the end point passed in url param
     *
     * @param url    The endpoint (popular, top rated or playing now movies)
     * @param params The query params like (apikey, language, page...)
     * @return Call<MovieCatalog>
     */
    @GET
    Call<MovieCatalog> getMovieCatalog(@Url String url, @QueryMap Map<String, String> params);

    /**
     * Return a call for specific movie detail
     *
     * @param movie_id Movie id
     * @param params   The query params like (apikey, language, page)
     * @return Call<MovieDetail>
     */
    @GET("movie/{movie_id}")
    Call<MovieDetail> getDetailMovie(@Path("movie_id") int movie_id, @QueryMap Map<String, String> params);


    /**
     * Return a call for all videos from specific movie. (trailers, clips)
     *
     * @param movie_id Movie id
     * @param params   The query params like (apikey, language, page...)
     * @return Call<TrailerCatalog>
     */
    @GET("movie/{movie_id}/videos")
    Call<TrailerCatalog> getMovieTrailer(@Path("movie_id") int movie_id, @QueryMap Map<String, String> params);


}
