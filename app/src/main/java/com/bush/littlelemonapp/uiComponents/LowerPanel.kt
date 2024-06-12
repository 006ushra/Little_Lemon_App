package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.local.HomeMenuItemLocal
import com.bush.littlelemonapp.navigation.DishDetails
import com.bush.littlelemonapp.uiTheme.LittleLemonTypography
import com.bush.littlelemonapp.uiTheme.ThemeColor
import com.bush.littlelemonapp.uiTheme.ThemeColor.charcoal
import com.bush.littlelemonapp.uiTheme.ThemeColor.cloud

@Composable
fun LowerPanel(menuList: List<HomeMenuItemLocal> = emptyList(), navController: NavHostController) {
    Column {
        WeeklySpecialCard()
        MenuSection(menuList, navController)
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
            color = charcoal,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MenuSection(menuList: List<HomeMenuItemLocal>, navController: NavHostController) {
    var category by remember {
        mutableStateOf("")
    }
    var filteredList: List<HomeMenuItemLocal>

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Button(
                onClick = { category = "starters" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cloud,
                    contentColor = charcoal
                )
            ) {
                Text(text = "Starters", style = LittleLemonTypography.labelSmall)
            }
            Button(
                onClick = { category = "mains" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cloud,
                    contentColor = charcoal
                )
            ) {
                Text(text = "Mains", style = LittleLemonTypography.labelSmall)
            }
            Button(
                onClick = { category = "desserts" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cloud,
                    contentColor = charcoal
                )
            ) {
                Text(text = "Desserts", style = LittleLemonTypography.labelSmall)
            }
            Button(
                onClick = { category = "" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cloud,
                    contentColor = charcoal
                )
            ) {
                Text(text = "All", style = LittleLemonTypography.labelSmall)
            }
        }
        filteredList = if (category.isNotBlank()) {
            menuList.filter {
                it.category == category
            }
        } else {
            menuList
        }

        LazyColumn {
            itemsIndexed(filteredList) { _, item ->
                MenuDish(item, navController)
            }
        }
    }


}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuDish(menuItem: HomeMenuItemLocal, navController:NavHostController? = null) {
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
                    text = menuItem.title,
                    style = LittleLemonTypography.displayMedium,
                    color = charcoal,
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
            GlideImage(
                model = menuItem.image,
                contentDescription = menuItem.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(80.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 1.dp,
            color = ThemeColor.yellow
        )
    }
}