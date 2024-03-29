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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun UpperPanel() {
    Column(
        modifier = Modifier
            .background(ThemeColor.green)
            .padding(
                horizontal = 12.dp,
                vertical = 16.dp
            )
    ) {
        Text(
            text = "Little Lemon",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = ThemeColor.yellow
        )
        Text(
            text = "Chicago",
            fontSize = 24.sp,
            color = ThemeColor.cloud
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
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
            onClick = {},
            colors = ButtonColors(
                ThemeColor.yellow,
                ThemeColor.charcoal,
                ThemeColor.paleYellow,
                ThemeColor.grey
            )
        ) {
            Text(
                text = "Order Take Away",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    UpperPanel()
}