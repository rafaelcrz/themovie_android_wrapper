package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Rafael Felipe on 28/05/2017.
 */

public class Company implements Parcelable {

    private String name;
    private int id;

    public Company() {
    }

    protected Company(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }


    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };
}
