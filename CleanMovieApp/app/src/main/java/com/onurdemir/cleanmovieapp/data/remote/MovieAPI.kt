package com.onurdemir.cleanmovieapp.data.remote

import com.onurdemir.cleanmovieapp.data.remote.dto.MovieDetailDto
import com.onurdemir.cleanmovieapp.data.remote.dto.MoviesDto
import com.onurdemir.cleanmovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //https://www.omdbapi.com/?apikey=c34d3c12&s=batman

    //https://www.omdbapi.com/?apikey=c34d3c12&i=tt0372784

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto


}