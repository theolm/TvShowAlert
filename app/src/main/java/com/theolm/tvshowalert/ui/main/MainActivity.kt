package com.theolm.tvshowalert.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.theolm.tvshowalert.ui.components.MainAppBar
import com.theolm.tvshowalert.ui.components.ShowCard
import com.theolm.tvshowalert.ui.theme.TvShowAlertTheme
import com.theolm.tvshowalert.ui.theme.horizontalMainPadding
import com.theolm.tvshowalert.ui.theme.verticalMainPadding
import kotlin.math.roundToInt

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
            MainAppBar(modifier = Modifier.fillMaxWidth())
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