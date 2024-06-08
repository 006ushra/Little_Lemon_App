package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.ReserveTable
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun UpperPanel(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .background(ThemeColor.green)
            .padding(
                horizontal = 12.dp,
                vertical = 16.dp
            )
    ) {
        Text(
            text = stringResource(id = R.string.little_lemon),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = ThemeColor.yellow
        )
        Text(
            text = stringResource(id = R.string.chicago),
            fontSize = 24.sp,
            color = ThemeColor.cloud
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.restaurant_desc),
                fontSize = 16.sp,
                letterSpacing = 0.5.sp,
                color = ThemeColor.cloud,
                modifier = Modifier
                    .padding(bottom = 28.dp, end = 20.dp)
                    .fillMaxWidth(0.6f)
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "home image",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
        Button(
            onClick = {
                      navController?.navigate(ReserveTable.route)
            },
            colors = ButtonColors(
                ThemeColor.yellow,
                ThemeColor.charcoal,
                ThemeColor.paleYellow,
                ThemeColor.grey
            )
        ) {
            Text(
                text = stringResource(id = R.string.reserve_button),
                fontWeight = FontWeight.Bold
            )
        }
    }
}