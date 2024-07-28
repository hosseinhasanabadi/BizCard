package com.example.bizcard.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Elevation (

    val extraSmall : Dp =4.dp
)
val LocalElevation = compositionLocalOf { Elevation()  }
val MaterialTheme.elevation : Elevation
@Composable
@ReadOnlyComposable
get() = LocalElevation.current