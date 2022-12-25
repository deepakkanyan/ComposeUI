package com.example.jetpackcomp.data

import com.example.jetpackcomp.model.PopularMovieData
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("3/movie/popular/")
   suspend fun getPopularMoviesList(
        @Query("api_key") apiKey: String
    ): PopularMovieData

}