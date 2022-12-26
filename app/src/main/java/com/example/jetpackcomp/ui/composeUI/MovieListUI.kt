package com.example.jetpackcomp.ui.composeUI


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.jetpackcomp.R
import com.example.jetpackcomp.navigation.Route
import com.example.jetpackcomp.theme.JPColors
import com.example.jetpackcomp.ui.theme.MyTypography
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel
import com.example.jetpackcomp.utils.CommonJetpackUI
import com.example.jetpackcomp.utils.JPConstants
import com.example.jetpackcomp.utils.addArgument

@Composable
fun MovieListUI(navController : NavHostController){
    val viewModel = hiltViewModel<MovieViewModel>()
    val listData = viewModel.movieList.observeAsState().value ?: arrayListOf()
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
                            navController.navigate(Route.DetailsMovie.addArgument(movie.id))
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

                        Text(
                            text = movie.voteAverage.toString(),
                            Modifier
                                .padding(5.dp)
                                .background(JPColors.Primary, shape = RoundedCornerShape(3.dp))
                                .padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 2.dp),
                            maxLines = 1,
                            style = MyTypography.labelSmall.copy(color = JPColors.White)
                        )

                    }

                }
            }
        }
    }

}