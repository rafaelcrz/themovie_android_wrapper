package com.github.rafaelcrz.tmdbandroidwrapper_lib.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael Felipe on 26/05/2017.
 */

class Client {

    private static Retrofit retrofit;
    private static int cacheSize = 10 * 1024 * 1024;//10 MB for cache

    /**
     * This method return a Retrofit custon client
     *
     * @param context The aplication context. Using on the okhttp cache
     * @return Retrofit
     */
    public static Retrofit getRetrofitClient(Context context) {
        if (retrofit == null) {

            Cache cache = new Cache(context.getCacheDir(), cacheSize); //Okttp cache

            OkHttpClient okHttpClient = new OkHttpClient.Builder() //Custon client
                    .cache(cache) //set the cache
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(TheMovieService.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()) //for the response parse
                    .build();
        }
        return retrofit;
    }
}
