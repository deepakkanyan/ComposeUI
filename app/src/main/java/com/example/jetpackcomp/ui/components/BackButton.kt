package com.example.jetpackcomp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.jetpackcomp.theme.White

@Composable
fun BackButton(onBackPressed : () -> Unit ) {

    IconButton(onClick = {
        onBackPressed.invoke()

    }, Modifier.shadow(clip = true, elevation = 2.dp)) {
        Icon(Icons.Filled.ArrowBack, null, tint = White)
    }

}
