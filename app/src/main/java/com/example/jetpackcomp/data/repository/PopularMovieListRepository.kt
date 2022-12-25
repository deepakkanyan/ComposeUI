package com.example.jetpackcomp.data.repository

import com.example.jetpackcomp.data.datasource.popularmovies.DataListDataSource
import com.example.jetpackcomp.data.datasource.popularmovies.LocalDataList
import com.example.jetpackcomp.data.datasource.popularmovies.RemoteDataList
import com.example.jetpackcomp.model.PopularMovieData
import javax.inject.Inject

class PopularMovieListRepository @Inject constructor(
    private val remoteSource: RemoteDataList,
    private val localSource: LocalDataList
) : DataListDataSource {

    override suspend fun fetchPopularMovieListApi(apiKey : String): PopularMovieData {
        return remoteSource.fetchPopularMovieListApi(apiKey)
    }

    override fun saveDataList() {
        localSource.saveDataList()
    }

    override fun getDataListDB(): List<PopularMovieData> {
        throw UnsupportedOperationException()
    }
}