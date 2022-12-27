package com.example.jetpackcomp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomp.base.JPBaseActivity
import com.example.jetpackcomp.navigation.JPNavigation
import com.example.jetpackcomp.theme.*
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : JPBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MovieViewModel>()
            JPTheme {
                val navController = rememberNavController()
                JPNavigation(navController = navController, viewModel = viewModel)
            }
        }
    }


}