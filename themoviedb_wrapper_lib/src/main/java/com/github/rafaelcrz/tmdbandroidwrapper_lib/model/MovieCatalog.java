package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Rafael Felipe on 26/05/2017.
 */

public class MovieCatalog implements Parcelable {

    private int page;
    private List<Movie> results;
    private int total_pages;
    private int total_results;


    public MovieCatalog() {
    }

    protected MovieCatalog(Parcel in) {
        page = in.readInt();
        results = in.createTypedArrayList(Movie.CREATOR);
        total_pages = in.readInt();
        total_results = in.readInt();
    }

    public int getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeTypedList(results);
        dest.writeInt(total_pages);
        dest.writeInt(total_results);
    }

    public static final Creator<MovieCatalog> CREATOR = new Creator<MovieCatalog>() {
        @Override
        public MovieCatalog createFromParcel(Parcel in) {
            return new MovieCatalog(in);
        }

        @Override
        public MovieCatalog[] newArray(int size) {
            return new MovieCatalog[size];
        }
    };
}
