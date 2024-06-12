package com.bush.littlelemonapp.uiComponents

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.uiTheme.ThemeColor.charcoal
import com.bush.littlelemonapp.uiTheme.ThemeColor.yellow

@Composable
fun MyAccount(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LittleLemonApp", Context.MODE_PRIVATE)
    var date by remember {
        mutableStateOf(sharedPreferences.getString("day", "").toString() + "/" + sharedPreferences.getString("month", ""))
    }

    Column {
        TopAppBar(navController)
        Column(
            Modifier
                .weight(1f)
                .padding(start = 20.dp, end = 20.dp, top = 40.dp)
        ) {

            Text(
                text = "Reservation Information",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(text = stringResource(id = R.string.full_name))
                OutlinedTextField(
                    value = sharedPreferences.getString("fullName", "").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.email), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = sharedPreferences.getString("email", "").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.phone), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = sharedPreferences.getString("phone", "").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.date), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = date,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.time), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = sharedPreferences.getString("time", "").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.diners), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = sharedPreferences.getString("number", "").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.notes), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = sharedPreferences.getString("notes", "").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Button(
            onClick = {
                Toast.makeText(context, "Reservation cancelled.", Toast.LENGTH_SHORT).show()
                sharedPreferences.edit()
                    .remove("fullName")
                    .remove("email")
                    .remove("phone")
                    .remove("day")
                    .remove("month")
                    .remove("time")
                    .remove("number")
                    .remove("notes")
                    .apply()
                date = ""
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow,
                contentColor = charcoal
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {
            Text(text = "Cancel Reservation")
        }
    }
}