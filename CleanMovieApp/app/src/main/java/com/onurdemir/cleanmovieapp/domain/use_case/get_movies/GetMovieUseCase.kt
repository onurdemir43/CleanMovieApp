package com.onurdemir.cleanmovieapp.domain.use_case.get_movies

import com.onurdemir.cleanmovieapp.data.remote.dto.toMovieList
import com.onurdemir.cleanmovieapp.domain.model.Movie
import com.onurdemir.cleanmovieapp.domain.repository.MovieRepository
import com.onurdemir.cleanmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository : MovieRepository) {

    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No movie found!"))
            }
        } catch (e : IOError) {
            emit(Resource.Error(message = "No internet connection!"))
        } catch (e : HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }

}