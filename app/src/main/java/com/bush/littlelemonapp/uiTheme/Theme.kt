package com.bush.littlelemonapp.uiTheme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColorScheme(
    primary = ThemeColor.yellow,
    secondary = ThemeColor.pink
)
private val DarkColorPalette = darkColorScheme(
    primary = ThemeColor.paleYellow,
    secondary = ThemeColor.pink
)

@Composable
fun LittleLemonTheme (darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable ()->Unit) {
    if (!darkTheme) {
        MaterialTheme(
            colorScheme = LightColorPalette,
            shapes = MaterialTheme.shapes,
            typography = LittleLemonTypography,
            content = content)
    } else {
        MaterialTheme(
            colorScheme = DarkColorPalette,
            shapes = MaterialTheme.shapes,
            typography = LittleLemonTypography,
            content = content)
    }
}