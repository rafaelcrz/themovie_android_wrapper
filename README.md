# Themovie Android Wrapper

This is a wrapper for <a href="https://www.themoviedb.org/documentation/api">The Moviedb</a> API version 3

This project uses the <a href="http://square.github.io/retrofit/Retrofit">Retrofit</a> to create interfaces from tmdb API endpoints.

## This project is on development.

## Endpoint available:
Movie
- GetCatalog Movies (Popular, Playing now, Top rated)
- Get Videos from movies
- Get detail movie

## Integrating into your project

This project is available in [JitPack.io](https://jitpack.io/) repository.

## Add into build.gradle
```java
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
## Add into app/build.gradle
```java
dependencies {
  compile 'com.github.rafaelcrz:themovie_android_wrapper:master-SNAPSHOT'
}
```
## API KEY
[How get the "Themoviedb" API KEY](https://developers.themoviedb.org/3/getting-started)

## Endpoints availables

### Movie (popular, top rated and playing now movies)
TheMovieApi.NOW_PLAYING, TheMovieApi.POPULAR, TheMovieApi.TOP_RATED
### Detail movie
Return a detail of specific movie
### Video
Return a catalog video from a specific movie

## Samples
### Simple
* This project has a simple sample, for get the Popular Movies.
### Complete
* It's a complete sample [themoviedb_android_client](https://github.com/rafaelcrz/themoviedb_android_client).


## Usage

```java
//Create a new instance for API
TheMovieApi theMovieApi = new TheMovieApi(mContext, "YOUR_API_KEY");

//Default lenguage is the local device
theMovieApi.setLanguage("pt-BR");

//Set the number page
theMovieApi.setPage("1"); //If you need do a infinit scroll set the page in the requests call

//Get a catalog movie
theMovieApi.getMovieCatalog(TheMovieApi.NOW_PLAYING, new TheMovieApiListener<MovieCatalog>() {
    @Override
    public void onResponse(Call<MovieCatalog> call, Response<MovieCatalog> movieResultResponse) {
        if (movieResultResponse.isSuccessful()) {
            MovieCatalog movieCatalog = movieResultResponse.body();
            for (Movie movie : movieCatalog.getResults()) {
                Log.i(TAG,movie.getTitle());
            }
            total_page = movieResultResponse.body().getTotal_pages(); //Total pages return from the API
        }else{
          Log.e(TAG,"HTTP_CODE -> "+movieResultResponse.code());
        }
    }

    @Override
    public void onFailure(Call<MovieCatalog> call, Throwable throwable) {
        throwable.printStackTrace();
    }
});
```
