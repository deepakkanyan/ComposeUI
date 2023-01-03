package com.example.jetpackcomp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomp.theme.MyTypography
import com.example.jetpackcomp.theme.Primary
import com.example.jetpackcomp.theme.White


@Composable
fun ratingView(rating: String) : Modifier {
    val modifier = Modifier
        .padding(5.dp)
        .background(Primary, shape = RoundedCornerShape(3.dp))
        .padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 2.dp)
    Text(
        text = rating,
        modifier,
        maxLines = 1,
        style = MyTypography.labelSmall.copy(color = White)
    )
    return  modifier
}

