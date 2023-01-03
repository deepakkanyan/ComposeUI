package com.example.jetpackcomp.data.repository

import androidx.lifecycle.LiveData
import com.example.jetpackcomp.data.datasource.popularmovies.DataListDataSource
import com.example.jetpackcomp.data.datasource.popularmovies.LocalDataList
import com.example.jetpackcomp.data.datasource.popularmovies.RemoteDataList
import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.model.PopularMovieData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMovieListRepository @Inject constructor(
    private val remoteSource: RemoteDataList,
    private val localSource: LocalDataList
) : DataListDataSource {

    override suspend fun fetchPopularMovieListApi(apiKey: String): PopularMovieData {
        return remoteSource.fetchPopularMovieListApi(apiKey)
    }

    override suspend fun saveDataList(movieList: List<MovieDetails>) {
        localSource.saveDataList(movieList)
    }

    override  fun getDataListDB(): Flow<List<MovieDetails>> {
        return localSource.getDataListDB()
    }

    override  fun getMovieDetailsByID(movieID: Long): Flow<MovieDetails> {
        return localSource.getMovieDetailsByID(movieID)
    }
}