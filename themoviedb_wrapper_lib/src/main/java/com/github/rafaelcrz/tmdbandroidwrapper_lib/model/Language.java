package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rafael Felipe on 26/05/2017.
 */

public class Language implements Parcelable {

    private String iso_639_1;
    private String name;

    public Language() {}

    protected Language(Parcel in) {
        iso_639_1 = in.readString();
        name = in.readString();
    }

    public static final Creator<Language> CREATOR = new Creator<Language>() {
        @Override
        public Language createFromParcel(Parcel in) {
            return new Language(in);
        }

        @Override
        public Language[] newArray(int size) {
            return new Language[size];
        }
    };

    public String getIso_639_1() {
        return iso_639_1;
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
        dest.writeString(iso_639_1);
        dest.writeString(name);
    }
}
