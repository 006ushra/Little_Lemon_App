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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.local.HomeMenuItemLocal
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun LowerPanel(menuList: List<HomeMenuItemLocal> = emptyList()) {
    Column {
        WeeklySpecialCard()
        LazyColumn {
            itemsIndexed(menuList) {_ , item ->
                MenuDish(item)
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
            text = "Weekly Special",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = ThemeColor.charcoal,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MenuDish(menuItem: HomeMenuItemLocal) {
    val imageId = when (menuItem.id) {
        1 -> R.drawable.greeksalad
        2 -> R.drawable.lemondessert
        3 -> R.drawable.bruschetta
        4 -> R.drawable.grilledfish
        5 -> R.drawable.pasta
        6 -> R.drawable.lasagne
        else -> R.drawable.launcher_img
    }
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = menuItem.name,
                    color = ThemeColor.charcoal,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = menuItem.description,
                    color = ThemeColor.green,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = "$${menuItem.price}",
                    fontWeight = FontWeight.Bold,
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

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview() {
    LowerPanel()
}