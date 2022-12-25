package com.example.jetpackcomp.data.datasource.popularmovies

import com.example.jetpackcomp.model.PopularMovieData


class LocalDataList : DataListDataSource {

    override suspend fun fetchPopularMovieListApi(apiKey : String): PopularMovieData {
        throw UnsupportedOperationException()
    }

    override fun saveDataList() {
        throw UnsupportedOperationException()
    }

    override fun getDataListDB(): List<PopularMovieData> {
        throw UnsupportedOperationException()
    }

}