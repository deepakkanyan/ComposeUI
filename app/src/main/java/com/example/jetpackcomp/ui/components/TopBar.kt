package com.example.jetpackcomp.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomp.theme.MyTypography
import com.example.jetpackcomp.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = { Text(text = title, style = MyTypography.bodyLarge) },
        Modifier.background(Primary),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, null,tint = Primary)
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Search, null, tint = Primary)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Notifications, null, tint = Primary)
            }
        }

    )
}
