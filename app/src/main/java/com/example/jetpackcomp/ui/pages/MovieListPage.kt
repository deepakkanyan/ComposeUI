package com.example.jetpackcomp.ui.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.jetpackcomp.R
import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.navigation.Route
import com.example.jetpackcomp.theme.White
import com.example.jetpackcomp.ui.components.ratingView
import com.example.jetpackcomp.ui.components.TopBar
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel
import com.example.jetpackcomp.utils.JPConstants.END_POINT_IMAGE

@Composable
fun MovieListPage(navController: NavHostController, viewModel: MovieViewModel) {

    val movieList = viewModel.movieList.observeAsState().value ?: arrayListOf()

    Column {

        TopBar(title = stringResource(id = R.string.movie_list))

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(movieList) { movie ->

                MovieCard(movie, navController, viewModel)
            }
        }
    }
}


@Composable
fun MovieCard(
    movieDetail: MovieDetails, navController: NavController, viewModel: MovieViewModel
) {

    Card(
        Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(300.dp)
            .clickable {
                viewModel.getMovieDetailsByID(movieDetail.id)
                navController.navigate(Route.DetailsMovie)
            }, shape = RoundedCornerShape(5.dp)
    ) {
        Box(Modifier.background(White)) {

            AsyncImage(
                model = END_POINT_IMAGE.plus(movieDetail.posterPath),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxHeight(),
                contentScale = ContentScale.FillBounds
            )

            ratingView(rating = movieDetail.voteAverage.toString())

        }

    }
}