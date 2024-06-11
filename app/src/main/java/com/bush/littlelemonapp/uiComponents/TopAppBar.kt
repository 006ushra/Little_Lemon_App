package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bush.littlelemonapp.navigation.Account
import com.bush.littlelemonapp.navigation.Home
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.navigation.Settings

@Composable
fun TopAppBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = { navController.navigate(Settings.route) }
        ) {
            Image(
                painter = painterResource(id = R.drawable.settings_ic),
                contentDescription = "sidebar_menu",
                modifier = Modifier.size(24.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(horizontal = 20.dp)
                .clickable {
                    if (currentDestination != Home.route) {
                        navController.navigate(Home.route)
                    }
                }
        )
        IconButton(
            onClick = { navController.navigate(Account.route) }
        ) {
            Image(
                painter = painterResource(id = R.drawable.account_ic),
                contentDescription = "cart",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}