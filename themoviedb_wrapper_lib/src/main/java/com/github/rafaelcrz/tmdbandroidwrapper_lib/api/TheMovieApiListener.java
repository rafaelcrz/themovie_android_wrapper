package com.github.rafaelcrz.tmdbandroidwrapper_lib.api;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Rafael Felipe on 26/05/2017.
 * <p>
 * The general Listener
 */

/**
 * @param <T> The type listener. It is setting on the TheMovieApi class methods
 */
public interface TheMovieApiListener<T> {

    public void onResponse(Call<T> call, Response<T> movieResultResponse);

    public void onFailure(Call<T> call, Throwable throwable);

}
