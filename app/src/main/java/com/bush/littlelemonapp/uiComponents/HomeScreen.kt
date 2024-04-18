package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.local.HomeMenuItemLocal

@Composable
fun HomeScreen(
    menuList: List<HomeMenuItemLocal>,
    navController: NavHostController,
    openDrawer: () -> Unit
) {
    Column {
        TopAppBar(navController, openDrawer)
        UpperPanel(navController)
        LowerPanel(menuList, navController)
    }
}