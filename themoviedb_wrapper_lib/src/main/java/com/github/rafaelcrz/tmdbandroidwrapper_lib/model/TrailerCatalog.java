package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Rafael Felipe on 26/05/2017.
 */

public class TrailerCatalog implements Parcelable {

    private int id;
    private List<Trailer> results;

    public TrailerCatalog() {
    }

    protected TrailerCatalog(Parcel in) {
        id = in.readInt();
        results = in.createTypedArrayList(Trailer.CREATOR);
    }

    public static final Creator<TrailerCatalog> CREATOR = new Creator<TrailerCatalog>() {
        @Override
        public TrailerCatalog createFromParcel(Parcel in) {
            return new TrailerCatalog(in);
        }

        @Override
        public TrailerCatalog[] newArray(int size) {
            return new TrailerCatalog[size];
        }
    };

    public int getId() {
        return id;
    }

    public List<Trailer> getResults() {
        return results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeTypedList(results);
    }
}
