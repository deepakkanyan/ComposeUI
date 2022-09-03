package com.example.jetpackcomp.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/*
* This is global  app scaffold
* which is modified with custom themes to make
* it centralized
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: @Composable (() -> Unit) = {},
    bottomBar: @Composable (() -> Unit) = {},
    floatingActionButton: @Composable (() -> Unit) = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
){

   Scaffold(
      modifier = modifier,
       scaffoldState = scaffoldState,
       topBar = topBar,
       bottomBar = bottomBar,
       floatingActionButton = floatingActionButton,
       floatingActionButtonPosition = floatingActionButtonPosition){}
}