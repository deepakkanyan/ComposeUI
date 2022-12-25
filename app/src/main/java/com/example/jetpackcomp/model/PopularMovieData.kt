package com.example.jetpackcomp.model

import com.squareup.moshi.Json

data class PopularMovieData(
    @Json(name = "page")
    val page: Long,
    @Json(name = "results")
    val results: List<MovieList>,
    @Json(name = "total_pages")
    val totalPages: Long,
    @Json(name = "total_results")
    val totalResults: Long
)

data class MovieList(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "genre_ids")
    val genreIDS: List<Long>,
    @Json(name = "id")
    val id: Long,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Long
)