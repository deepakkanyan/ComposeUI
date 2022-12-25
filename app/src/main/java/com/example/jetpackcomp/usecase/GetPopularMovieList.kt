package com.example.jetpackcomp.usecase

import com.example.jetpackcomp.BuildConfig
import com.example.jetpackcomp.data.repository.PopularMovieListRepository
import com.example.jetpackcomp.model.PopularMovieData

class GetPopularMovieList(private val moviesRepository : PopularMovieListRepository) {

   suspend fun invoke() : PopularMovieData{
        return  moviesRepository.fetchPopularMovieListApi(BuildConfig.API_KEY)
    }
}