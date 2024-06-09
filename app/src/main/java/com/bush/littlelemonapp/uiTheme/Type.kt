package com.bush.littlelemonapp.uiTheme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bush.littlelemonapp.R

val markaziFontFamily = FontFamily(
    Font(R.font.markazitext_regular)
)

val karlaFontFamily = FontFamily(
    Font(R.font.karla_regular)
)

val LittleLemonTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = markaziFontFamily,
        fontSize = 64.sp,
        fontWeight = FontWeight.Medium
    ),
    titleMedium = TextStyle(
        fontFamily = markaziFontFamily,
        fontSize = 40.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = karlaFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    labelSmall = TextStyle(
        fontFamily = karlaFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    displayLarge = TextStyle(
        fontFamily = karlaFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    displayMedium = TextStyle(
        fontFamily = karlaFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    displaySmall = TextStyle(
        fontFamily = karlaFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    )
)