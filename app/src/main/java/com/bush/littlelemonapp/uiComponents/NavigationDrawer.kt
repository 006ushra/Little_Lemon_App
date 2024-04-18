package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        DrawerAppScreen.Home -> HomeScreen(menuItemsList, navController, openDrawer)
        DrawerAppScreen.MyAccount -> MyAccount(openDrawer)
        DrawerAppScreen.Settings -> SettingsScreen(openDrawer)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1Component(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        // TopAppBar has slots for a title, navigation icon,
        // and actions. Also known as the action bar.
        TopAppBar(
            title = { Text("Screen 1 Title") },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )
        Surface(color = Color(0xFFffd7d7.toInt()), modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = "Geeks for geeks : Geeks learning from geeks")
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2Component(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Screen 2 Title") },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )
        Surface(color = Color(0xFFffe9d6.toInt()), modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = "GFG : GeeksforGeeks was founded by Sandeep Jain")
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen3Component(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Screen 3 Title") },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )
        Surface(color = Color(0xFFfffbd0.toInt()), modifier = Modifier.weight(1f)) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = "Address: A-143, 9th Floor, Sovereign Corporate Tower Sector-136, Noida, Uttar Pradesh - 201305")
                }
            )
        }
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