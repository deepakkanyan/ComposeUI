package com.example.jetpackcomp.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomp.theme.JPColors
import com.example.jetpackcomp.ui.composeUI.MovieDetailsUI
import com.example.jetpackcomp.ui.composeUI.MovieListUI
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel


object Route {
    const val DashBoardMovie = "DashBoardMovie"
    const val DetailsMovie = "DetailsMovie"
}

@Composable
fun JPNavigation(
    navController: NavHostController,
    viewModel: MovieViewModel) {
    NavHost(navController = navController, startDestination = Route.DashBoardMovie, Modifier.background(
        JPColors.Background)) {

        composable(route = Route.DashBoardMovie) {
            MovieListUI(navController = navController,viewModel)
        }
        composable(route = Route.DetailsMovie) {
            MovieDetailsUI(navController,viewModel)
        }
    }
}

