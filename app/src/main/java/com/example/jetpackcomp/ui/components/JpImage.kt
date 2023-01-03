package com.example.jetpackcomp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.jetpackcomp.R
import com.example.jetpackcomp.utils.EMPTY_STRING
import com.example.jetpackcomp.utils.JPConstants


@Composable
fun JpImage(imageUrl : String,scaleType : ContentScale) {
    AsyncImage(
        model = JPConstants.END_POINT_IMAGE.plus(imageUrl),
        contentDescription = EMPTY_STRING,
        Modifier.fillMaxWidth(),
        contentScale = scaleType,
        placeholder = painterResource(id = R.drawable.image_placeholder),

        )
}