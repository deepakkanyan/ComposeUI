package com.example.jetpackcomp.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomp.theme.Background
import com.example.jetpackcomp.ui.pages.MovieDetailsPage
import com.example.jetpackcomp.ui.pages.MovieListPage
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel


object Route {
    const val DashBoardMovie = "DashBoardMovie"
    const val DetailsMovie = "DetailsMovie"
}

@Composable
fun JPNavigation(
    navController: NavHostController,
    viewModel: MovieViewModel) {
    NavHost(navController = navController, startDestination = Route.DashBoardMovie,
        Modifier.background(Background)) {

        composable(route = Route.DashBoardMovie) {
            MovieListPage(navController = navController,viewModel)
        }
        composable(route = Route.DetailsMovie) {
            MovieDetailsPage(navController,viewModel)
        }
    }
}

