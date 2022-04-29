package com.theolm.tvshowalert.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theolm.tvshowalert.ui.theme.horizontalMainPadding

@Preview
@Composable
private fun Preview() {
    MainAppBar(title = "Tv Shows")
}

@Composable
fun MainAppBar(modifier: Modifier = Modifier, title: String, background: Color = Color.Transparent) {
    TopAppBar(
        modifier = modifier.testTag(MainAppBar.TestTag),
        elevation = 0.dp,
        backgroundColor = background
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalMainPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 28.sp,
                fontWeight = FontWeight.Black,
                color = Color.Black
            )
        }
    }
}

internal object MainAppBar {
    const val TestTag = "MainAppBarTestTag"
}
