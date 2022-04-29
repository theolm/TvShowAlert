package com.theolm.tvshowalert.ui.components

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainAppBarKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        composeRule.setContent {
            MainAppBar()
        }
    }

    @Test
    fun checkIfIsVisible() {
        getComponent().assertExists().assertIsDisplayed()
    }

    @Test
    fun testText() {
        getComponent().onChild().assertTextEquals("Tv Shows")
        //try again2
    }

    private fun getComponent() = composeRule.onNodeWithTag(MainAppBar.TestTag, useUnmergedTree = true)
}