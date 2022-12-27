package com.example.jetpackcomp.ui.composeUI


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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.jetpackcomp.R
import com.example.jetpackcomp.navigation.Route
import com.example.jetpackcomp.theme.JPColors
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel
import com.example.jetpackcomp.utils.CommonJetpackUI
import com.example.jetpackcomp.utils.JPConstants

@Composable
fun MovieListUI(navController: NavHostController, viewModel: MovieViewModel){

    val listData  = viewModel.movieList.observeAsState().value ?: arrayListOf()
    Column {
        CommonJetpackUI.JPTopBar(title = stringResource(id = R.string.movie_list))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(listData) { movie ->
                Card(
                    Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable {
                            viewModel.getMovieDetailsByID(movie.id)
                            navController.navigate(Route.DetailsMovie)
                        },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Box(Modifier.background(JPColors.White)) {

                        AsyncImage(
                            model = JPConstants.END_POINT_IMAGE.plus(movie.posterPath),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxHeight(),
                            contentScale = ContentScale.FillBounds
                        )

                        CommonJetpackUI.ratingView(rating = movie.voteAverage.toString())

                    }

                }
            }
        }
    }

}