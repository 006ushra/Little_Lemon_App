package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun ReserveTableForm() {
    Column {
        TopAppBar()
        ReserveUpperPanel()
        Form()
    }
}

@Composable
fun ReserveUpperPanel() {
    Column(
        modifier = Modifier
            .background(ThemeColor.yellow)
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Reserve a Table at Our Restaurant",
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            color = ThemeColor.charcoal
        )
        Text(
            text = "Now you can book a table with only a few taps. And you can enjoy all the goodness of traditional mediterranean food at your preferred time.",
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            color = ThemeColor.charcoal,
            modifier = Modifier
                .padding(top = 32.dp, bottom = 28.dp)
        )
        Text(
            text = "Please fill out this form to book a table.",
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            color = ThemeColor.charcoal,
        )
    }
}

@Composable
fun Form() {
    var step by remember {
        mutableStateOf(1)
    }
    when(step){
        1 -> FormStepOne(step)
        2 -> FormStepTwo(step)
        3 -> FormStepThree(step)
        else -> FormStepThree(step)
    }
    Button(
        onClick = {step++},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = if (step == 3) {
                "Submit"
            } else {
                "Next"
            }
        )
    }
}

@Composable
fun FormStepOne(step: Int) {
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp, bottom = 47.dp)
    ) {
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Full Name")
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Email")
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Phone Number")
            },
            onValueChange = {}
        )
    }
}

@Composable
fun FormStepTwo(step: Int) {
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp, bottom = 47.dp)
    ) {
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Reservation Date")
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Reservation Time")
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Number of Diners")
            },
            onValueChange = {}
        )
    }
}

@Composable
fun FormStepThree(step: Int) {
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp, bottom = 47.dp)
    ) {
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Additional Notes")
            },
            onValueChange = {}
        )
    }
}

@Composable
fun StepsCounter(step: Int) {
    Image(
        painter = painterResource(
            id = when(step) {
                1 -> R.drawable.progress1
                2 -> R.drawable.progress2
                3 -> R.drawable.progress3
                else -> {R.drawable.progress3}
            }
        ),
        contentDescription = "Step $step",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .padding(
                top = 27.dp,
                bottom = 38.dp,
                start = 74.dp,
                end = 74.dp
            )
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
}

@Composable
fun TitleCard(step: Int) {
    Text(
        text = if (step == 1) "Personal Information" else "About The Reservation",
        fontSize = 24.sp,
        color = ThemeColor.charcoal,
        modifier = Modifier.padding(start = 16.dp)
    )
}