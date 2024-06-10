package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.local.HomeMenuItemLocal

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