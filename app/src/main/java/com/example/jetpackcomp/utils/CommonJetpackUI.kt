package com.example.jetpackcomp.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.jetpackcomp.ui.theme.Cool

object CommonJetpackUI {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun JPTopBar(title: String) {
        TopAppBar(title = { Text(text = title, style = Cool.CoolDown.bodyLarge) },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu, null)
                }
            })
    }
}