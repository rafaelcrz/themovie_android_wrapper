# Themovie Android Wrapper

This is a wrapper for <a href="https://www.themoviedb.org/documentation/api">The Moviedb</a> API version 3

This project uses the <a href="http://square.github.io/retrofit/Retrofit">Retrofit</a> to create interfaces from tmdb API endpoints.

This project is in development.

## Endpoint available:
Movie
- GetCatalog Movies (Popular, Playing now, Top rated)
- Get Videos from movies
- Get detail movie 

## Integrating into your project

This project is available in <a href="https://jitpack.io/">JitPack.io</a> repository.

## Add into |Project| build.gradle 
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
## Add into |Module app| build.gradle 
```
dependencies {
  compile 'com.github.rafaelcrz:themovie_android_wrapper:0.0.2'
}
```
## API KEY
<a href="https://developers.themoviedb.org/3/getting-started">How get the "Themoviedb" API KEY</a>

## Endpoints availables

### Movie (popular, top rated and playing now movies)
TheMovieApi.NOW_PLAYING, TheMovieApi.POPULAR, TheMovieApi.TOP_RATED
### Detail movie
Return a detail of specific movie
### Video
Return a catalog video from a specific movie

## Usage

```
//Create a new instance for API
      TheMovieApi theMovieApi = new TheMovieApi(mContext, "YOUR_API_KEY");
      
//Default lenguage is the local device
      theMovieApi.setLanguage("pt-BR");

//Get a catalog movie
      theMovieApi.getMovieCatalog(TheMovieApi.NOW_PLAYING, new TheMovieApiListener<MovieCatalog>() {
            @Override
            public void onResponse(Call<MovieCatalog> call, Response<MovieCatalog> movieResultResponse) {
                if (movieResultResponse.isSuccessful()) {
                    MovieCatalog movieCatalog = movieResultResponse.body();
                    for (Movie movie : movieCatalog.getResults()) {
                        Log.i(TAG,movie.getTitle());
                    }
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



