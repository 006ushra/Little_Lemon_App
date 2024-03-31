package com.bush.littlelemonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.bush.littlelemonapp.local.AppDatabase
import com.bush.littlelemonapp.remote.HomeMenu
import com.bush.littlelemonapp.remote.HomeMenuItem
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }
    private val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database")
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val homeMenuList by database.menuItemDao().getAll().observeAsState(emptyList())
                Column {
                    TopAppBar()
                    UpperPanel()
                    LowerPanel(homeMenuList)
                }
            }
        }
        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {
                saveHomeMenuItems(getHomeMenuItems())
            }
        }
    }

    private suspend fun getHomeMenuItems(): List<HomeMenuItem> {
        val response = httpClient.get("https://raw.githubusercontent.com/006ushra/Little_Lemon_App/master/home_screen_menu.json") {
            header("Authorization", "TOKEN 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")
        }
            .body<HomeMenu>()
        return response.menu
    }

    private fun saveHomeMenuItems(itemsList: List<HomeMenuItem>) {
        val localItemsList = itemsList.map {
            it.convertToLocalItem()
        }
        database.menuItemDao().insertAll(localItemsList)
    }
}