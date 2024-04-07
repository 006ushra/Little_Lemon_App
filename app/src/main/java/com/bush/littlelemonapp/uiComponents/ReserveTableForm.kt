package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun ReserveTableForm() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        TopAppBar()
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
        4 -> FormStepFour()
        else -> FormStepFour()
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 47.dp)
    ) {
        if (step != 4) {
            Button(
                onClick = {
                    step--
                    if (step <= 0) {
                        //navigate to home
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 7.dp)
            ) {
                Text(
                    text = "Back"
                )
            }
        }
        Button(
            onClick = {step++},
            modifier = Modifier
                .weight(1f)
                .padding(start = 7.dp)
        ) {
            Text(
                text = when (step) {
                    3 -> { "Submit" }
                    4 -> { "Home" }
                    else -> { "Next" }
                }
            )
        }
    }
}

@Composable
fun FormStepOne(step: Int) {
    ReserveUpperPanel()
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp)
    ) {
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Full Name*")
            },
            supportingText = {
                Text(text = "* Required")
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Email*")
            },
            supportingText = {
                Text(text = "* Required")
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Phone Number")
            },
            supportingText = {
                Text(text = "For contact regarding the booking.")
            },
            onValueChange = {}
        )
    }
}

@Composable
fun FormStepTwo(step: Int) {
    ReserveUpperPanel()
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp)
    ) {
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Reservation Date*")
            },
            supportingText = {
                Text(text = "* Required")
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Reservation Time*")
            },
            supportingText = {
                Text(text = "* Required")
            },
            onValueChange = {}
        )
        Text(
            text = "Number of Diners",
            modifier = Modifier.padding(top = 5.dp)
        )
        Counter()
    }
}

@Composable
fun FormStepThree(step: Int) {
    ReserveUpperPanel()
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp)
    ) {
        OutlinedTextField(
            value = "",
            label = {
                Text(text = "Additional Notes")
            },
            onValueChange = {},
            supportingText = {
                Text(text = "Any thing for us to look out for; allergies, special requests, ...etc.")
            }
        )
    }
}

@Composable
fun FormStepFour() {
    Column(
        modifier = Modifier
            .background(ThemeColor.green)
            .padding(horizontal = 12.dp, vertical = 16.dp)

    ) {
        Text(
            text = "Thank you!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = ThemeColor.yellow,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
        )
        Text(
            text = "Table successfully booked.",
            fontSize = 24.sp,
            color = ThemeColor.cloud,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "We sent you a confirmation email. Please check it out.",
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            color = ThemeColor.cloud,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 116.dp)
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