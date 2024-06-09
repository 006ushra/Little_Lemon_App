package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.DishDetails
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.local.HomeMenuItemLocal
import com.bush.littlelemonapp.uiTheme.LittleLemonTypography
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun LowerPanel(menuList: List<HomeMenuItemLocal> = emptyList(), navController: NavHostController) {
    Column {
        WeeklySpecialCard()
        LazyColumn {
            itemsIndexed(menuList) {_ , item ->
                MenuDish(item, navController)
            }
        }
    }
}

@Composable
fun WeeklySpecialCard(){
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.weekly_special),
            style = LittleLemonTypography.displayLarge,
            color = ThemeColor.charcoal,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MenuDish(menuItem: HomeMenuItemLocal, navController:NavHostController? = null) {
    val imageId = getDishImageId(menuItem.id)
    Surface(
        onClick = {
            navController?.navigate(DishDetails.route+"/${menuItem.id}")
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = menuItem.name,
                    style = LittleLemonTypography.displayMedium,
                    color = ThemeColor.charcoal,
                )
                Text(
                    text = menuItem.description,
                    style = LittleLemonTypography.displaySmall,
                    color = ThemeColor.green,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = "$${menuItem.price}",
                    style = LittleLemonTypography.displayMedium,
                    color = ThemeColor.green
                )
            }
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Dish Name",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 1.dp,
            color = ThemeColor.yellow
        )
    }
}

fun getDishImageId(id: Int): Int {
    return when (id) {
        1 -> R.drawable.greeksalad
        2 -> R.drawable.lemondessert
        3 -> R.drawable.bruschetta
        4 -> R.drawable.grilledfish
        5 -> R.drawable.pasta
        6 -> R.drawable.lasagne
        else -> R.drawable.launcher_img
    }
}