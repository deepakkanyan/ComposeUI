package com.example.jetpackcomp.usecase.movies

import androidx.lifecycle.LiveData
import com.example.jetpackcomp.BuildConfig
import com.example.jetpackcomp.data.repository.PopularMovieListRepository
import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.model.PopularMovieData
import kotlinx.coroutines.flow.Flow

class GetPopularMovieList(private val moviesRepository : PopularMovieListRepository) {

   suspend fun invoke() : PopularMovieData{
        return  moviesRepository.fetchPopularMovieListApi(BuildConfig.API_KEY)
    }

     fun getPopularMovieList() : Flow<List<MovieDetails>> {
       return moviesRepository.getDataListDB()
    }

    fun getPopularMovieByID(movieID : Long) : Flow<MovieDetails> {
        return moviesRepository.getMovieDetailsByID(movieID)
    }
}