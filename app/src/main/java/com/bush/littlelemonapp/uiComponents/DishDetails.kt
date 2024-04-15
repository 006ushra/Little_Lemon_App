package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.local.HomeMenuItemLocal
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun DishDetails (dish: HomeMenuItemLocal, navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        TopAppBar(navController)
        Image(
            painter = painterResource(id = getDishImageId(dish.id)),
            contentDescription = dish.name,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Column {
            Text(
                text = dish.name,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = ThemeColor.charcoal
            )
            Text(
                text = dish.description,
                color = ThemeColor.green
            )
            Counter()
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            ) {
                Text(
                    text = "Add for $${dish.price}",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun Counter() {
    var counter by remember {
        mutableStateOf(1)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextButton(
            onClick = {
                counter--
            }
        ) {
            Text(
                text = "-",
                color = ThemeColor.charcoal,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        OutlinedTextField(
            value = counter.toString(),
            onValueChange = {},
            readOnly = true,
            textStyle = TextStyle().copy(textAlign = TextAlign.Center),
            modifier = Modifier.padding(16.dp)
                .width(60.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                color = ThemeColor.charcoal,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
