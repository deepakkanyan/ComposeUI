package com.example.jetpackcomp.data.datasource.popularmovies


import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.model.PopularMovieData
import kotlinx.coroutines.flow.Flow

interface DataListDataSource {
    suspend fun fetchPopularMovieListApi(apiKey : String ): PopularMovieData
    suspend fun saveDataList(movieList: List<MovieDetails>)
    fun getDataListDB(): Flow<List<MovieDetails>>
    fun getMovieDetailsByID(movieID : Long) : Flow<MovieDetails>
}