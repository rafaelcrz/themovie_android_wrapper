package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Rafael Felipe on 26/05/2017.
 */

public class Country implements Parcelable {

    private String iso_3166_1;
    private String name;

    public Country() {}

    protected Country(Parcel in) {
        iso_3166_1 = in.readString();
        name = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iso_3166_1);
        dest.writeString(name);
    }
}
