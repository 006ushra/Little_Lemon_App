package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecialCard()
        LazyColumn {
            items(4){
                MenuDish()
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
fun MenuDish() {
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = "Dish Name",
                    color = ThemeColor.charcoal,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Dish Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    color = ThemeColor.green,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = "\$Dish Price",
                    fontWeight = FontWeight.Bold,
                    color = ThemeColor.green
                )
            }
            Image(
                painter = painterResource(id = R.drawable.bruschetta),
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