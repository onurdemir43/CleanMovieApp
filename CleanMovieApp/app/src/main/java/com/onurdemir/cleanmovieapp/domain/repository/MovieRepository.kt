package com.onurdemir.cleanmovieapp.domain.repository

import com.onurdemir.cleanmovieapp.data.remote.dto.MovieDetailDto
import com.onurdemir.cleanmovieapp.data.remote.dto.MoviesDto
import com.onurdemir.cleanmovieapp.data.remote.dto.Search

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto

}