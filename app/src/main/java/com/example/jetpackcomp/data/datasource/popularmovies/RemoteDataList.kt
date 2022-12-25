package com.example.jetpackcomp.data.datasource.popularmovies

import com.example.jetpackcomp.data.Api
import com.example.jetpackcomp.model.PopularMovieData
import javax.inject.Inject

class RemoteDataList @Inject constructor(private val api: Api) : DataListDataSource {
    override suspend fun fetchPopularMovieListApi(apiKey : String): PopularMovieData {
        return api.getPopularMoviesList(apiKey)
    }

    override fun saveDataList() {
        throw UnsupportedOperationException()
    }

    override fun getDataListDB(): List<PopularMovieData> {
        throw UnsupportedOperationException()
    }
}