package com.bush.littlelemonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.bush.littlelemonapp.uiComponents.TopAppBar
import com.bush.littlelemonapp.uiComponents.UpperPanel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                TopAppBar()
                UpperPanel()
            }
        }
    }
}