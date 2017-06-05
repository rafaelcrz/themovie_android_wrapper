package com.github.rafaelcrz.tmdbandroidwrapper_lib.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Rafael Felipe on 26/05/2017.
 */

public class MovieDetail implements Parcelable {

    private boolean adult;
    private String backdrop_path;
    private Belong belongs_to_collection;
    private int budget;
    private List<Genre> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private List<Company> production_companies;
    private List<Country> production_countries;
    private String release_date;
    private int revenue;
    private int runtime;
    private List<Language> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private float vote_average;
    private int vote_count;
    private TrailerCatalog videos;

    public MovieDetail() {
    }

    protected MovieDetail(Parcel in) {
        adult = in.readByte() != 0;
        backdrop_path = in.readString();
        belongs_to_collection = (Belong) in.readParcelable(Belong.class.getClassLoader());
        budget = in.readInt();
        genres = in.createTypedArrayList(Genre.CREATOR);
        homepage = in.readString();
        id = in.readInt();
        imdb_id = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        overview = in.readString();
        popularity = in.readFloat();
        poster_path = in.readString();
        production_companies = in.createTypedArrayList(Company.CREATOR);
        production_countries = in.createTypedArrayList(Country.CREATOR);
        release_date = in.readString();
        revenue = in.readInt();
        runtime = in.readInt();
        spoken_languages = in.createTypedArrayList(Language.CREATOR);
        status = in.readString();
        tagline = in.readString();
        title = in.readString();
        video = in.readByte() != 0;
        vote_average = in.readFloat();
        vote_count = in.readInt();
        videos = (TrailerCatalog) in.readParcelable(TrailerCatalog.class.getClassLoader());
    }

    public static final Creator<MovieDetail> CREATOR = new Creator<MovieDetail>() {
        @Override
        public MovieDetail createFromParcel(Parcel in) {
            return new MovieDetail(in);
        }

        @Override
        public MovieDetail[] newArray(int size) {
            return new MovieDetail[size];
        }
    };

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getBudget() {
        return budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public List<Country> getProduction_countries() {
        return production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<Language> getSpoken_languages() {
        return spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideo() {
        return video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public Belong getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public List<Company> getProduction_companies() {
        return production_companies;
    }

    public TrailerCatalog getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return "MovieDetail{" +
                "adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", belongs_to_collection=" + belongs_to_collection +
                ", budget=" + budget +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + production_companies +
                ", production_countries=" + production_countries +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + spoken_languages +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                "videos" + videos +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(backdrop_path);
        dest.writeParcelable(belongs_to_collection, flags);
        dest.writeInt(budget);
        dest.writeTypedList(genres);
        dest.writeString(homepage);
        dest.writeInt(id);
        dest.writeString(imdb_id);
        dest.writeString(original_language);
        dest.writeString(original_title);
        dest.writeString(overview);
        dest.writeFloat(popularity);
        dest.writeString(poster_path);
        dest.writeTypedList(production_companies);
        dest.writeTypedList(production_countries);
        dest.writeString(release_date);
        dest.writeInt(revenue);
        dest.writeInt(runtime);
        dest.writeTypedList(spoken_languages);
        dest.writeString(status);
        dest.writeString(tagline);
        dest.writeString(title);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeFloat(vote_average);
        dest.writeInt(vote_count);
        dest.writeParcelable(videos, flags);
    }
}
