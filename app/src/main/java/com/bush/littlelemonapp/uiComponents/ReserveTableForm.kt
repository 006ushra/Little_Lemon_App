package com.bush.littlelemonapp.uiComponents

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.navigation.Home
import com.bush.littlelemonapp.uiTheme.ThemeColor

@Composable
fun ReserveTableForm(navController: NavHostController? = null) {
    val sharedPreferences = LocalContext.current.getSharedPreferences("LittleLemonApp", Context.MODE_PRIVATE)
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        if (navController != null) {
            TopAppBar(navController)
        }
        Form(navController, sharedPreferences)
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
fun Form(navController: NavHostController? = null, sharedPreferences: SharedPreferences) {
    var step by remember {
        mutableIntStateOf(1)
    }
    var secondFormValues = mapOf<String, String>()

    when (step) {
        0 -> {
            FormStepOne(step, sharedPreferences)
        }

        1 -> {
            FormStepOne(step, sharedPreferences)
        }

        2 -> {
            secondFormValues = formStepTwo(step)
        }

        3 -> {
            FormStepThree(step, sharedPreferences)
        }

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
                } else if (step == 3) {
                    sharedPreferences.edit()
                        .putString("day", secondFormValues["day"])
                        .putString("month", secondFormValues["month"])
                        .putString("time", secondFormValues["time"])
                        .putString("number", secondFormValues["number"])
                        .apply()
                }
            },
            modifier = Modifier
                .weight(1f)
                .padding(start = 7.dp)
        ) {
            Text(
                text = when (step) {
                    3 -> {
                        stringResource(id = R.string.submit)
                    }

                    4 -> {
                        stringResource(id = R.string.home)
                    }

                    5 -> {
                        stringResource(id = R.string.home)
                    }

                    else -> {
                        stringResource(id = R.string.next)
                    }
                }
            )
        }
    }
}

@Composable
fun FormStepOne(step: Int, sharedPreferences: SharedPreferences) {
    var fullName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }

    ReserveUpperPanel()
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp)
    ) {
        OutlinedTextField(
            value = fullName,
            label = {
                Text(text = stringResource(id = R.string.full_name) + "*")
            },
            supportingText = {
                Text(text = "* " + stringResource(id = R.string.required))
            },
            onValueChange = {
                fullName = it
                sharedPreferences.edit().putString("fullName", fullName).apply()
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            isError = fullName.isNotEmpty() &&  !isTextFieldValid(fullName, "name")
        )
        OutlinedTextField(
            value = email,
            label = {
                Text(text = stringResource(id = R.string.email) + "*")
            },
            supportingText = {
                Text(text = "* " + stringResource(id = R.string.required))
            },
            onValueChange = {
                email = it
                sharedPreferences.edit().putString("email", email).apply()
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = email.isNotEmpty() &&  !isTextFieldValid(email, "email")
        )
        OutlinedTextField(
            value = phone,
            label = {
                Text(text = stringResource(id = R.string.phone))
            },
            supportingText = {
                Text(text = stringResource(id = R.string.phone_subtext))
            },
            onValueChange = {
                phone = it
                sharedPreferences.edit().putString("phone", phone).apply()
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            isError = phone.isNotEmpty() &&  !isTextFieldValid(phone, "phone")
        )
    }
}

@Composable
fun formStepTwo(step: Int): MutableMap<String, String> {
    val days = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31")
    val months = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    val hours = listOf("10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00")
    val values = mutableMapOf<String, String>()

    ReserveUpperPanel()
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 22.dp)
    ) {
        Text(
            text = stringResource(id = R.string.date) + "*"
        )
        Row {
            values["day"] = dropDownComponent(label = "Day", options = days, 0.5f)
            values["month"] = dropDownComponent(label = "Month", options = months, 1f)
        }

        Text(
            text = stringResource(id = R.string.time) + "*",
            modifier = Modifier.padding(top = 10.dp)
        )
        Row {
            values["time"] = dropDownComponent(label = "Hour", options = hours, 0.5f)
        }

        Text(
            text = stringResource(id = R.string.diners),
            modifier = Modifier.padding(top = 10.dp)
        )
        values["number"] = counter().toString()
    }
    return values
}

@Composable
fun FormStepThree(step: Int, sharedPreferences: SharedPreferences) {
    var notes by remember {
        mutableStateOf("")
    }
    ReserveUpperPanel()
    StepsCounter(step)
    TitleCard(step)
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 22.dp)
    ) {
        OutlinedTextField(
            value = notes,
            label = {
                Text(text = stringResource(id = R.string.notes))
            },
            onValueChange = { notes = it
                sharedPreferences.edit().putString("notes", notes).apply()},
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
            id = when (step) {
                0 -> R.drawable.progress1
                1 -> R.drawable.progress1
                2 -> R.drawable.progress2
                3 -> R.drawable.progress3
                else -> {
                    R.drawable.progress3
                }
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

fun isTextFieldValid(value: String, type: String): Boolean {
    return when (type) {
        "name" -> {
            value.length >= 3 && value.matches(Regex("[a-zA-Z]+"))
        }

        "email" -> {
            value.matches(Regex("([\\w\\.]+)@([\\w\\.]+)\\.(\\w+)"))
        }

        "phone" -> {
            value.matches(Regex("(\\+?( |-|\\.)?\\d{1,2}( |-|\\.)?)?(\\(?\\d{3}\\)?|\\d{3})( |-|\\.)?(\\d{3}( |-|\\.)?\\d{4})"))
        }

        else -> {
            false
        }
    }
}