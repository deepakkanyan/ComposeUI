package com.example.jetpackcomp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Database
import androidx.room.Room
import com.example.jetpackcomp.model.room.JPDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomDbModule {

    private const val DB_NAME = "Movie_DB"

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context,) : JPDatabase {
            val dbBuilder = Room.databaseBuilder(context, JPDatabase::class.java, DB_NAME)
            return dbBuilder.build()
        }

}