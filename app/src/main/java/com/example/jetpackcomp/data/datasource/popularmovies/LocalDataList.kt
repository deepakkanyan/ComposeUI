package com.example.jetpackcomp.data.datasource.popularmovies


import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.model.PopularMovieData
import com.example.jetpackcomp.model.room.JPDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocalDataList @Inject constructor(private val db: JPDatabase) : DataListDataSource {

    override suspend fun fetchPopularMovieListApi(apiKey: String): PopularMovieData {
        throw UnsupportedOperationException()
    }

    override suspend fun saveDataList(movieList: List<MovieDetails>) {
        db.movieDio().saveMovieList(movieList)
    }

    override  fun getDataListDB(): Flow<List<MovieDetails>> {
        return db.movieDio().getMovieList()
    }

    override  fun getMovieDetailsByID(movieID: Long): Flow<MovieDetails> {
        return db.movieDio().getMovieDetailsByID(movieID)
    }
}