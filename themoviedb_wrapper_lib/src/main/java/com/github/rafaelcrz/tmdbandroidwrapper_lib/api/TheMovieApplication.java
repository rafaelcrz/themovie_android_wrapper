package com.github.rafaelcrz.tmdbandroidwrapper_lib.api;

import android.app.Application;

/**
 * Created by Rafael Felipe on 26/05/2017.
 * <p>
 * This class application need is seting on Manifest file.
 * <p>
 * <application
 * android:name="com.github.rafaelcrz.tmdbandroidwrapper_lib.api.TheMovieApplication"
 */

public class TheMovieApplication extends Application {

    private TheMovieService theMovieService;

    @Override
    public void onCreate() {

        //Client.getRetrofitClient(getApplicationContext()) return a retrofit client
        //.create(TheMovieService.class) Create a service
        theMovieService = Client.getRetrofitClient(getApplicationContext()).create(TheMovieService.class);
        super.onCreate();

    }

    /**
     * Make the TheMovieService a 'global' variable for some uses.
     *
     * @return TheMovieService with all calls
     */
    public TheMovieService getTheMovieService() {
        try {
            return theMovieService;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
