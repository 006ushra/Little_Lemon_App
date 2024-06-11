package com.bush.littlelemonapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bush.littlelemonapp.local.AppDatabase
import com.bush.littlelemonapp.local.HomeMenuItemLocal
import com.bush.littlelemonapp.uiComponents.DishDetails
import com.bush.littlelemonapp.uiComponents.HomeScreen
import com.bush.littlelemonapp.uiComponents.MyAccount
import com.bush.littlelemonapp.uiComponents.ReserveTableForm
import com.bush.littlelemonapp.uiComponents.SettingsScreen

@Composable
fun Navigation(homeMenuList: List<HomeMenuItemLocal>, database: AppDatabase) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route) {
        composable(
            Home.route
        ) {
            HomeScreen(homeMenuList, navController)
        }
        composable(
            DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(navArgument(DishDetails.argDishId) {type = NavType.IntType})
        ) {
            val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) {
                "dish id is Null"
            }
            val dish by database.menuItemDao().getDish(id).observeAsState(
                HomeMenuItemLocal(10, "Please try again", "Please try again", 0.0, "Please try again", "Please try again")
            )
            DishDetails(dish, navController)
        }
        composable(
            ReserveTable.route
        ) {
            ReserveTableForm(navController)
        }
        composable(
            Settings.route
        ) {
            SettingsScreen(navController)
        }
        composable(
            Account.route
        ) {
            MyAccount(navController)
        }
    }
}