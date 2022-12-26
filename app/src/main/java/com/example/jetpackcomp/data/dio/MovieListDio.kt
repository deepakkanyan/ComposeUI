package com.example.jetpackcomp.data.dio

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jetpackcomp.model.MovieDetails
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MovieListDio {

    @Query("Select * From movie_list")
    abstract fun getMovieList() : Flow<List<MovieDetails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveMovieList(movieDetails: List<MovieDetails>)

    @Query("Select * From movie_list Where id = :movieID")
    abstract fun getMovieDetailsByID(movieID : Long) : Flow<MovieDetails>
}