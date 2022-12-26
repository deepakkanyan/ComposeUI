package com.example.jetpackcomp.ui.composeUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.jetpackcomp.ui.theme.MyTypography
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel
import com.example.jetpackcomp.utils.JPConstants

@Composable
fun MovieDetailsUI(movieID: String?) {
    val viewModel = hiltViewModel<MovieViewModel>()
    movieID?.let { id ->
        viewModel.getMovieDetailsByID(id.toLong())
        val movieDetails = viewModel.movieDetails.observeAsState().value
        movieDetails?.let { movie ->

            Box {
                AsyncImage(
                    model = JPConstants.END_POINT_IMAGE.plus(movieDetails?.posterPath),
                    contentDescription = "",
                    Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Card(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .alpha(1f)
                        .height(300.dp)
                        .fillMaxWidth()) {
                    Box(Modifier.background(Color.White)) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(20.dp)

                        ) {

                            Text(text = movie.title, style = MyTypography.bodyLarge)
                            Text(text = movie.originalLanguage, style = MyTypography.bodyLarge)
                            Text(text = movie.releaseDate, style = MyTypography.bodyLarge)
                            Text(text = movie.overview, style = MyTypography.bodyLarge)


                        }
                    }

                }


            }

        }

    }

}