package com.example.jetpackcomp.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcomp.theme.JPColors
import com.example.jetpackcomp.ui.composeUI.MovieDetailsUI
import com.example.jetpackcomp.ui.composeUI.MovieListUI


object Route {
    const val DashBoardMovie = "DashBoardMovie"
    const val DetailsMovie = "DetailsMovie"
}

object ArgKeys{
    const val valueKey = "value"
}


@Composable
fun JPNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Route.DashBoardMovie, Modifier.background(
        JPColors.Background)) {

        composable(route = Route.DashBoardMovie) {
            MovieListUI(navController = navController)
        }
        composable(
            route = "${Route.DetailsMovie}/{${ArgKeys.valueKey}}",
            arguments = listOf(
                navArgument(ArgKeys.valueKey) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            MovieDetailsUI(backStackEntry.arguments?.getString(ArgKeys.valueKey))
        }
    }
}

