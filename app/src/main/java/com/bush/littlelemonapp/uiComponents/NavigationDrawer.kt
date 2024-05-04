package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.bush.littlelemonapp.local.HomeMenuItemLocal
import com.bush.littlelemonapp.uiTheme.ThemeColor
import kotlinx.coroutines.launch

@Composable
fun DrawerAppComponent(menuItemsList: List<HomeMenuItemLocal>) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentScreen = remember {
        mutableStateOf(DrawerAppScreen.Home)
    }
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            DrawerContentComponent(
                currentScreen = currentScreen,
                closeDrawer = {
                    coroutineScope.launch { drawerState.close() }
                }
            )
        },
        content = {
            BodyContentComponent(
                currentScreen = currentScreen.value,
                menuItemsList,
                openDrawer = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }
            )
        }
    )
}

@Composable
fun DrawerContentComponent(
    currentScreen: MutableState<DrawerAppScreen>,
    closeDrawer: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (index in DrawerAppScreen.values().indices) {
            val screen = getScreenBasedOnIndex(index)
            Column(
                modifier = Modifier.clickable {
                currentScreen.value = screen
                closeDrawer()
            }
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = if(currentScreen.value == screen) {
                        ThemeColor.paleYellow
                    } else {
                        ThemeColor.cloud
                    }
                ) {
                    Text(
                        text = screen.name,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

fun getScreenBasedOnIndex(index: Int) = when(index) {
    0 -> DrawerAppScreen.Home
    1 -> DrawerAppScreen.MyAccount
    2 -> DrawerAppScreen.Settings
    else -> DrawerAppScreen.Home
}

@Composable
fun BodyContentComponent(
    currentScreen: DrawerAppScreen,
    menuItemsList: List<HomeMenuItemLocal>,
    openDrawer: () -> Unit
) {
    val navController = rememberNavController()
    when(currentScreen) {
        DrawerAppScreen.Home -> HomeScreen(menuItemsList, navController/*, openDrawer*/)
        DrawerAppScreen.MyAccount -> MyAccount(openDrawer)
        DrawerAppScreen.Settings -> SettingsScreen(openDrawer)
    }
}

enum class DrawerAppScreen {
    Home,
    MyAccount,
    Settings
}

@Preview
@Composable
fun DrawerAppComponentPreview() {
    val list = listOf(
        HomeMenuItemLocal(1, "name1", "description1", 1f),
        HomeMenuItemLocal(2, "name2", "description2", 2f),
        HomeMenuItemLocal(3, "name3", "description3", 3f),
    )
    DrawerAppComponent(list)
}