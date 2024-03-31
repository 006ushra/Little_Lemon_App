package com.bush.littlelemonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.lifecycleScope
import com.bush.littlelemonapp.remote.HomeMenu
import com.bush.littlelemonapp.uiComponents.LowerPanel
import com.bush.littlelemonapp.uiComponents.TopAppBar
import com.bush.littlelemonapp.uiComponents.UpperPanel
import com.bush.littlelemonapp.uiTheme.LittleLemonTheme
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                Column {
                    TopAppBar()
                    UpperPanel()
                    LowerPanel()
                }
            }
        }
        lifecycleScope.launch {
            getHomeMenuItems()
        }
    }

    private suspend fun getHomeMenuItems() {
        val response = httpClient.get("https://raw.githubusercontent.com/006ushra/Little_Lemon_App/master/home_screen_menu.json") {
            header("Authorization", "TOKEN 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")
        }
            .body<HomeMenu>()
        Log.d("RESPONSE", response.toString())
    }
}