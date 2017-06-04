package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Rafael Felipe on 26/05/2017.
 */

public class Genre implements Parcelable {

    private int id;
    private String name;

    public Genre() {}

    protected Genre(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
