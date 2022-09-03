package com.example.jetpackcomp.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomp.R
import com.example.jetpackcomp.data.getPropertyDetails


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CadPlaces() {
    Surface(
        color = MaterialTheme.colorScheme.background) {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text(text = "Cad App") },
                    navigationIcon = {
                        IconButton(onClick = { print("Clicked") }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Settings,
                                contentDescription = "Setting"
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.Info, contentDescription = "Info")
                        }
                              },

                    colors = TopAppBarDefaults.smallTopAppBarColors(),
                )
            },
            content = { innerPadding ->
                LazyVerticalGrid(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    cells = GridCells.Fixed(1)
                ) {
                    val list =  getPropertyDetails()
                    items(count = list.size) {
                        Box(modifier = Modifier.padding(120.dp))
                        Box{

                            Box(modifier = Modifier.fillParentMaxWidth()) {
                                Image(painter = painterResource(list[it].icon), contentDescription = "")
                            }

                            Box(modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(10.dp)
                                .background(colorResource(id = R.color.teal_700))){
                                Text(
                                    text = list[it].title,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }


                        }

                    }
                }
            },
            floatingActionButton= {
               FloatingActionButton(onClick = { }) {
                   Icon(imageVector = Icons.Default.Call, contentDescription = "",)
               }
            }
        )
    }


}