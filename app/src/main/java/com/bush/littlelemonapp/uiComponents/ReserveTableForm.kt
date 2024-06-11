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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.navigation.Home
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun ReserveTableForm(navController: NavHostController? = null) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        if (navController != null) {
            TopAppBar(navController)
        }
        Form(navController)
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
            text = stringResource(id = R.string.reserve_title),
            fontSize = 35.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            color = ThemeColor.charcoal
        )
        Text(
            text = stringResource(id = R.string.reserve_text),
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            color = ThemeColor.charcoal,
            modifier = Modifier
                .padding(top = 32.dp, bottom = 28.dp)
        )
        Text(
            text = stringResource(id = R.string.reserve_subtext),
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            color = ThemeColor.charcoal,
        )
    }
}

@Composable
fun Form(navController: NavHostController? = null) {
    var step by remember {
        mutableStateOf(1)
    }
    when(step){
        0 -> FormStepOne(step)
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
        if (step < 4) {
            Button(
                onClick = {
                    step--
                    if (step <= 0) {
                        navController?.navigate(Home.route)
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 7.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.back)
                )
            }
        }
        Button(
            onClick = {
                step++
                if (step > 4) {
                    navController?.navigate(Home.route)
                }
                      },
            modifier = Modifier
                .weight(1f)
                .padding(start = 7.dp)
        ) {
            Text(
                text = when (step) {
                    3 -> { stringResource(id = R.string.submit) }
                    4 -> { stringResource(id = R.string.home) }
                    5 -> { stringResource(id = R.string.home) }
                    else -> { stringResource(id = R.string.next) }
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
                Text(text = stringResource(id = R.string.full_name) + "*")
            },
            supportingText = {
                Text(text = "* " + stringResource(id = R.string.required))
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = stringResource(id = R.string.email) + "*")
            },
            supportingText = {
                Text(text = "* " + stringResource(id = R.string.required))
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = stringResource(id = R.string.phone))
            },
            supportingText = {
                Text(text = stringResource(id = R.string.phone_subtext))
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
                Text(text = stringResource(id = R.string.date) + "*")
            },
            supportingText = {
                Text(text = "* " + stringResource(id = R.string.required))
            },
            onValueChange = {}
        )
        OutlinedTextField(
            value = "",
            label = {
                Text(text = stringResource(id = R.string.time) + "*")
            },
            supportingText = {
                Text(text = "* " + stringResource(id = R.string.required))
            },
            onValueChange = {}
        )
        Text(
            text = stringResource(id = R.string.diners),
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
                Text(text = stringResource(id = R.string.notes))
            },
            onValueChange = {},
            supportingText = {
                Text(text = stringResource(id = R.string.notes_subtext))
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
            text = stringResource(id = R.string.thank_you),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = ThemeColor.yellow,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
        )
        Text(
            text = stringResource(id = R.string.reserve_success),
            fontSize = 24.sp,
            color = ThemeColor.cloud,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.success_subtext),
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
                0 -> R.drawable.progress1
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
        text = if (step <= 1) stringResource(id = R.string.personal_info) else stringResource(id = R.string.about_reservation),
        fontSize = 24.sp,
        color = ThemeColor.charcoal,
        modifier = Modifier.padding(start = 16.dp)
    )
}