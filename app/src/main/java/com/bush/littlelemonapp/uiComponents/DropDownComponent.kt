package com.bush.littlelemonapp.uiComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bush.littlelemonapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropDownComponent(label: String, options: List<String>, size: Float): String {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var selectedValue by remember {
        mutableStateOf(options[0])
    }
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded }) {
        OutlinedTextField(
            value = selectedValue,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = isExpanded
                )
            },
            label = { Text(text = label) },
            supportingText = { Text(text = "* " + stringResource(id = R.string.required)) },
            modifier = Modifier.menuAnchor()
                .fillMaxWidth(size)
                .padding(horizontal = 5.dp)
        )
        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            options.forEachIndexed { index, day ->
                DropdownMenuItem(
                    text = { Text(text = day) },
                    onClick = {
                        selectedValue = options[index]
                        isExpanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
    return selectedValue
}