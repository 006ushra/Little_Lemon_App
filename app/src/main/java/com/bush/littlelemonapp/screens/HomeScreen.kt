package com.bush.littlelemonapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.local.HomeMenuItemLocal
import com.bush.littlelemonapp.uiComponents.LowerPanel
import com.bush.littlelemonapp.uiComponents.TopAppBar
import com.bush.littlelemonapp.uiComponents.UpperPanel

@Composable
fun HomeScreen(
    menuList: List<HomeMenuItemLocal>,
    navController: NavHostController
) {
    Column {
        TopAppBar(navController)
        UpperPanel(navController)
        LowerPanel(menuList, navController)
    }
}