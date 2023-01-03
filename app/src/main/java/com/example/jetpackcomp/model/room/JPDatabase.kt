package com.example.jetpackcomp.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomp.data.dio.MovieListDio
import com.example.jetpackcomp.model.MovieDetails

@Database(entities = [MovieDetails::class], version = 1)
abstract class JPDatabase : RoomDatabase(){
    abstract fun movieDio() : MovieListDio
}