package com.example.jetpackcomp.di

import com.example.jetpackcomp.data.Api
import com.example.jetpackcomp.data.datasource.popularmovies.LocalDataList
import com.example.jetpackcomp.data.datasource.popularmovies.RemoteDataList
import com.example.jetpackcomp.data.repository.PopularMovieListRepository
import com.example.jetpackcomp.usecase.GetPopularMovieList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataListModule {

    @Provides
    @Singleton
    fun provideLocalDataSource() : LocalDataList{
        return LocalDataList()
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource( apiService: Api) : RemoteDataList{
        return RemoteDataList(apiService)
    }

    @Provides
    @Singleton
    fun provideGetSpotlightIds(repo : PopularMovieListRepository): GetPopularMovieList {
        return GetPopularMovieList(repo)
    }

}