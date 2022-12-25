package com.example.jetpackcomp.data.datasource.popularmovies

import com.example.jetpackcomp.model.PopularMovieData

interface DataListDataSource {
    suspend fun  fetchPopularMovieListApi(apiKey : String ): PopularMovieData
    fun saveDataList()
    fun getDataListDB(): List<PopularMovieData>
}