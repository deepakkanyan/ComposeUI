package com.example.jetpackcomp.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.jetpackcomp.theme.JPColors
import com.example.jetpackcomp.theme.MyTypography

object CommonJetpackUI {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun JPTopBar(title: String) {
        TopAppBar(
            title = { Text(text = title, style = MyTypography.bodyLarge) },
            Modifier.background(JPColors.Primary),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu, null,tint = JPColors.Primary)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Search, null, tint = JPColors.Primary)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Notifications, null, tint = JPColors.Primary)
                }
            }

        )
    }


    @Composable
    fun ratingView(rating: String) : Modifier{
        val modifier = Modifier
            .padding(5.dp)
            .background(JPColors.Primary, shape = RoundedCornerShape(3.dp))
            .padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 2.dp)
        Text(
            text = rating,
            modifier,
            maxLines = 1,
            style = MyTypography.labelSmall.copy(color = JPColors.White)
        )
        return  modifier
    }


    @Composable
    fun BackButton(onBackPressed : () -> Unit ) : Modifier{
        val modifier = Modifier
            .padding(5.dp)
            .background(JPColors.Primary, shape = RoundedCornerShape(3.dp))
            .padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 2.dp)
        IconButton(onClick = {
            onBackPressed.invoke()

        },Modifier.shadow(clip = true, elevation = 2.dp)) {
            Icon(Icons.Filled.ArrowBack, null, tint = JPColors.White)
        }
        return  modifier
    }


}