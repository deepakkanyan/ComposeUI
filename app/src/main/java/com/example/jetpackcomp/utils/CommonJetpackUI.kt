package com.example.jetpackcomp.utils

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomp.theme.JPColors
import com.example.jetpackcomp.ui.theme.MyTypography

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
}