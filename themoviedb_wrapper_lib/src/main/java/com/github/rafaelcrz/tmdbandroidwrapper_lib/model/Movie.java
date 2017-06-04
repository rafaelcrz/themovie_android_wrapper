package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Rafael Felipe on 26/05/2017.
 */

public class Movie implements Parcelable {

    private String poster_path;
    private boolean adult;
    private String overview;
    private String release_date;
    private List<Integer> genre_ids;
    private int id;
    private String original_title;
    private String original_language;
    private String title;
    private String backdrop_path;
    private float popularity;
    private int vote_count;
    private boolean video;
    private float vote_average;

    public Movie() {

    }

    protected Movie(Parcel in) {
        poster_path = in.readString();
        adult = in.readByte() != 0;
        overview = in.readString();
        release_date = in.readString();
        genre_ids = in.readArrayList(Integer.class.getClassLoader());
        id = in.readInt();
        original_title = in.readString();
        original_language = in.readString();
        title = in.readString();
        backdrop_path = in.readString();
        popularity = in.readFloat();
        vote_count = in.readInt();
        video = in.readByte() != 0;
        vote_average = in.readFloat();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getPoster_path() {
        return poster_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public int getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public float getPopularity() {
        return popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public float getVote_average() {
        return vote_average;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "poster_path='" + poster_path + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", genre_ids=" + genre_ids +
                ", id=" + id +
                ", original_title='" + original_title + '\'' +
                ", original_language='" + original_language + '\'' +
                ", title='" + title + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", popularity=" + popularity +
                ", vote_count=" + vote_count +
                ", video=" + video +
                ", vote_average=" + vote_average +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poster_path);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeInt(id);
        dest.writeString(original_title);
        dest.writeString(original_language);
        dest.writeString(title);
        dest.writeString(backdrop_path);
        dest.writeFloat(popularity);
        dest.writeInt(vote_count);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeFloat(vote_average);
        dest.writeList(genre_ids);
    }
}
