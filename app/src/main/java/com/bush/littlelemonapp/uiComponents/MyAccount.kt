package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bush.littlelemonapp.R
import com.bush.littlelemonapp.uiTheme.ThemeColor.charcoal
import com.bush.littlelemonapp.uiTheme.ThemeColor.yellow

@Composable
@Preview(showBackground = true)
fun MyAccount() {
    Column {
        Column(
            Modifier
                .weight(1f)
                .padding(start = 20.dp, end = 20.dp, top = 40.dp)
        ) {

            Text(
                text = stringResource(id = R.string.personal_info),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
            )
            Column(verticalArrangement = Arrangement.SpaceAround) {
                Text(text = stringResource(id = R.string.first_name))
                OutlinedTextField(
                    value = "first name",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.last_name), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = "last name",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = stringResource(id = R.string.email), modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = "email",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow,
                contentColor = charcoal
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {
            Text(text = stringResource(id = R.string.log_out))
        }
    }
}