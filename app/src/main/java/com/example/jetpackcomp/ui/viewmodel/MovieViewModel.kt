package com.example.jetpackcomp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomp.base.JPBaseViewModel
import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.usecase.movies.GetPopularMovieList
import com.example.jetpackcomp.usecase.movies.SavePopularMovieList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getPopularMovieList: GetPopularMovieList,
                                         private val savePopularMovieList: SavePopularMovieList) :
    JPBaseViewModel() {


    private var _movieList = MutableLiveData<List<MovieDetails>>()
    val movieList : LiveData<List<MovieDetails>> = _movieList


    private var _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails : LiveData<MovieDetails> = _movieDetails

    init {
        fetchMovieList()
        getMovieList()
    }

    private fun getMovieList() {
       viewModelScope.launch {
           getPopularMovieList.getPopularMovieList().collect{
               _movieList.value = it
           }
       }
    }

    private fun fetchMovieList() {
        viewModelScope.launch {
            val data = getPopularMovieList.invoke()
            savePopularMovieList.invoke(data.results)
        }
    }


    fun getMovieDetailsByID(movieID : Long){
        viewModelScope.launch {
                getPopularMovieList.getPopularMovieByID(movieID).collect { movieDetails ->
                    _movieDetails.value = movieDetails
                }
        }
    }

}