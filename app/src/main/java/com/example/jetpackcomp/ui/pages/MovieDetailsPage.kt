package com.example.jetpackcomp.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcomp.model.MovieDetails
import com.example.jetpackcomp.theme.MyTypography
import com.example.jetpackcomp.ui.components.BackButton
import com.example.jetpackcomp.ui.components.JpImage
import com.example.jetpackcomp.ui.components.ratingView
import com.example.jetpackcomp.ui.viewmodel.MovieViewModel

@Composable
fun MovieDetailsPage(navController : NavHostController,viewModel: MovieViewModel) {
       val movieDetails = viewModel.movieDetails.observeAsState().value
       movieDetails?.let { movie ->
            Box {

                JpImage(imageUrl = movieDetails.posterPath, scaleType = ContentScale.Crop)

                BackButton {
                    navController.popBackStack()
                }

                InfoCard(movie,
                    Modifier
                        .align(Alignment.BottomCenter)
                        .height(300.dp))

            }
        }



}

@Composable
fun InfoCard(movie: MovieDetails, modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        modifier = modifier
    ) {
        Box(
            Modifier
                .background(Color.White)
                .fillMaxHeight()) {
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()


            ) {

                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = movie.title,
                        Modifier.weight(.8f),
                        style = MyTypography.bodyLarge.copy(fontSize = 26.sp)
                    )

                        ratingView(rating = movie.voteAverage.toString())
                        .weight(.2f)
                }
                Text(text = movie.originalLanguage, style = MyTypography.bodyLarge)
                Text(text = movie.releaseDate, style = MyTypography.bodyLarge)
                Text(text = movie.overview, style = MyTypography.labelMedium)


            }
        }
    }

}
