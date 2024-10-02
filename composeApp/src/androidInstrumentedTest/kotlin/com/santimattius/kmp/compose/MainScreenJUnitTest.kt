package com.santimattius.kmp.compose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import kotlin.test.Test

class MainScreenJUnitTest {

    @get:Rule
    val rule = createComposeRule()


    @Test
    fun myFirstTest(): Unit = with(rule) {
        setContent {
            MainScreen()
        }
        onNodeWithText("You have pushed the button this many times").assertExists()
        onNodeWithText("0").assertExists()
        onNodeWithContentDescription("Increment").performClick()
        onNodeWithText("1").assertExists()
    }
}