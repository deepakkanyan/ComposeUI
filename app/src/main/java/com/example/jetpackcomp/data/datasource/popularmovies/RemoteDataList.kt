package com.example.jetpackcomp.data.datasource.popularmovies

import com.example.jetpackcomp.data.Api
import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.model.PopularMovieData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataList @Inject constructor(private val api: Api) : DataListDataSource {

    override suspend fun fetchPopularMovieListApi(apiKey: String): PopularMovieData {
        return api.getPopularMoviesList(apiKey)
    }

    override suspend fun saveDataList(movieList: List<MovieDetails>) {
        throw UnsupportedOperationException()
    }

    override fun getDataListDB(): Flow<List<MovieDetails>> {
        throw UnsupportedOperationException()
    }

    override fun getMovieDetailsByID(movieID: Long): Flow<MovieDetails> {
        throw UnsupportedOperationException()
    }
}