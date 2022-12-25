package com.example.jetpackcomp.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomp.base.JPBaseViewModel
import com.example.jetpackcomp.model.MovieList
import com.example.jetpackcomp.model.PopularMovieData
import com.example.jetpackcomp.usecase.GetPopularMovieList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val getPopularMovieList: GetPopularMovieList) :
    JPBaseViewModel() {


    private var _dataList = MutableLiveData<List<MovieList>>()
    val dataList = _dataList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val data = getPopularMovieList.invoke()
            print(data)
            _dataList.value = data.results
        }

    }

}