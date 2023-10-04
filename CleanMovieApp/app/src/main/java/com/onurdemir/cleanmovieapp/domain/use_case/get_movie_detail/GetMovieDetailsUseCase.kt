package com.onurdemir.cleanmovieapp.domain.use_case.get_movie_detail

import com.onurdemir.cleanmovieapp.data.remote.dto.toMovieDetail
import com.onurdemir.cleanmovieapp.data.remote.dto.toMovieList
import com.onurdemir.cleanmovieapp.domain.model.Movie
import com.onurdemir.cleanmovieapp.domain.model.MovieDetail
import com.onurdemir.cleanmovieapp.domain.repository.MovieRepository
import com.onurdemir.cleanmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository : MovieRepository) {

    fun executeGetMovieDetails(imdbId : String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId = imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e : IOError) {
            emit(Resource.Error(message = "No internet connection!"))
        } catch (e : HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }

}