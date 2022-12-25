package com.example.jetpackcomp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpackcomp.R
import com.example.jetpackcomp.base.JPBaseActivity
import com.example.jetpackcomp.theme.*
import com.example.jetpackcomp.ui.fragments.DataViewModel
import com.example.jetpackcomp.ui.theme.Cool
import com.example.jetpackcomp.utils.CommonJetpackUI
import com.example.jetpackcomp.utils.JPConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : JPBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPTheme {
                TopAppBarSample()
            }
        }
    }


    @Composable
    fun TopAppBarSample() {
        val viewModel by viewModels<DataViewModel>()
        Box(Modifier.background(Grey40)) {
            Column {
                CommonJetpackUI.JPTopBar(title = stringResource(id = R.string.movie_list))
                showMovieList(viewModel = viewModel)
            }
        }
    }

    @Composable
    fun showMovieList(viewModel: DataViewModel) {
        val listData = viewModel.dataList.observeAsState().value ?: arrayListOf()
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(listData) { movie ->
                Card(
                    Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .height(300.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Box(Modifier.background(Purple80)) {

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
                            Modifier.padding(5.dp)
                                .background(RedDark, shape = RoundedCornerShape(3.dp))
                                .padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 2.dp),
                            maxLines = 1,
                            style = Cool.CoolDown.labelSmall
                        )


                    }

                }
            }
        }


    }
}