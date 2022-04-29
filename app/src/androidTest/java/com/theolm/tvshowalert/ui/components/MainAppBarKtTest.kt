package com.theolm.tvshowalert.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onNodeWithTag
import com.theolm.tvshowalert.assertScreenshotMatchesGolden
import org.junit.Rule
import org.junit.Test

class MainAppBarKtTest {
    private val folderName = "appbar"

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun checkIfIsVisible() {
        setupContent()
        getComponent().assertExists().assertIsDisplayed()
    }

    @Test
    fun testText() {
        setupContent()
        getComponent().onChild().assertTextEquals("Tv Shows")
    }

    @Test
    fun snapTest1() {
        setupContent()
        assertScreenshotMatchesGolden(
            folderName = folderName,
            goldenName = "ss1",
            node = getComponent()
        )
    }

    @Test
    fun snapTest2() {
        setupContent(color = Color.Red)
        assertScreenshotMatchesGolden(
            folderName = folderName,
            goldenName = "ss2",
            node = getComponent()
        )
    }

    @Test
    fun snapTest3() {
        setupContent(color = Color.Blue)
        assertScreenshotMatchesGolden(
            folderName = folderName,
            goldenName = "ss3",
            node = getComponent()
        )
    }

    @Test
    fun snapTest4() {
        setupContent(title = "Snap Test", color = Color.White)
        assertScreenshotMatchesGolden(
            folderName = folderName,
            goldenName = "ss4",
            node = getComponent()
        )
    }

    private fun setupContent(title: String = "Tv Shows", color: Color = Color.Transparent) {
        composeRule.setContent {
            MainAppBar(
                title = title,
                background = color
            )
        }
    }

    private fun getComponent() =
        composeRule.onNodeWithTag(MainAppBar.TestTag, useUnmergedTree = true)
}
