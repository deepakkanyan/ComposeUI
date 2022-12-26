package com.example.jetpackcomp.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.jetpackcomp.ui.theme.*

@Composable
fun JPTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = MyTypography, content = content
    )
}