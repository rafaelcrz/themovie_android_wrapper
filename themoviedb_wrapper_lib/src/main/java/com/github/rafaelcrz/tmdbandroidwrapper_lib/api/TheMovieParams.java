package com.github.rafaelcrz.tmdbandroidwrapper_lib.api;

/**
 * Created by Rafael Felipe on 28/05/2017.
 *
 * Some paramns can be used for query.
 */

interface TheMovieParams {

    /**
     * Set the language for results. Default, the language used is the local device.
     *
     * @param language A string formaded by language and country.  (pt-BR)
     */
    void setLanguage(String language);

    /**
     * Set the page results
     *
     * @param page the page number
     */
    void setPage(int page);

    int getPage();
    //void setRegion(String region);
}
