package com.example.jetpackcomp.usecase.movies

import com.example.jetpackcomp.data.repository.PopularMovieListRepository
import com.example.jetpackcomp.model.MovieDetails

class SavePopularMovieList(private val moviesRepository : PopularMovieListRepository) {

    suspend fun invoke(movieList: List<MovieDetails>)  {
          moviesRepository.saveDataList(movieList)
    }
}