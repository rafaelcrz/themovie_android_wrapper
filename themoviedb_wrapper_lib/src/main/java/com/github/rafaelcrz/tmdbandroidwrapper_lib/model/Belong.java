package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rafael Felipe on 03/06/2017.
 */

class Belong implements Parcelable {

    private int id;
    private String name;
    private String poster_path;
    private String backdrop_path;

    public Belong() {}

    protected Belong(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.poster_path = in.readString();
        this.backdrop_path = in.readString();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
    }

    public static final Creator<Belong> CREATOR = new Creator<Belong>() {
        @Override
        public Belong createFromParcel(Parcel source) {
            return new Belong(source);
        }

        @Override
        public Belong[] newArray(int size) {
            return new Belong[size];
        }
    };
}
