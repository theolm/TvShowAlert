package com.theolm.tvshowalert.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.theolm.tvshowalert.ui.theme.grey1

@Preview
@Composable
private fun Preview() {
    ShowCard("https://assets-in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog@@icons@@like_202006280402.png,ox-24,oy-617,ow-29:q-80/et00319643-dcyqanxvvs-portrait.jpg")
}

@Composable
fun ShowCard(url: String) {
    val cardHeight = LocalConfiguration.current.screenHeightDp * 0.5
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight.dp),
        backgroundColor = grey1,
        elevation = 10.dp,
        shape = RoundedCornerShape(size = 24.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Black.copy(alpha = 0.8f)
                        )
                    )
                )
            )

            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = (cardHeight * 0.2).dp),
                text = "Venon",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight(800)
            )
        }




    }
}