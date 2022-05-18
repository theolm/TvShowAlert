package com.theolm.tvshowalert.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.theolm.tvshowalert.ui.components.MainAppBar
import com.theolm.tvshowalert.ui.components.ShowCard
import com.theolm.tvshowalert.ui.theme.TvShowAlertTheme
import com.theolm.tvshowalert.ui.theme.horizontalMainPadding
import com.theolm.tvshowalert.ui.theme.verticalMainPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvShowAlertTheme {
                Screen()
            }
        }
    }
}

@Composable
private fun Screen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MainAppBar(modifier = Modifier.fillMaxWidth(), title = "TV Shows")
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = horizontalMainPadding,
                vertical = verticalMainPadding
            ),
        ) {
            repeat(10) {
                item {
                    ShowCard(url = "https://i.pinimg.com/originals/bc/d5/c9/bcd5c9519581acc60bd60a429ab0c88f.jpg")
                    Spacer(modifier = Modifier.height(verticalMainPadding))
                }
            }
        }
    }
}

//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
//TEsting labels 2
