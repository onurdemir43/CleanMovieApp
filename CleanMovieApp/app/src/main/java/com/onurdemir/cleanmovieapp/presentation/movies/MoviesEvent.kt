package com.onurdemir.cleanmovieapp.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString : String) : MoviesEvent()
}