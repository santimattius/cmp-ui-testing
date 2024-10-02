package com.santimattius.kmp.compose

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class MainScreenTest {

    @Test
    fun myFirstTest() = runComposeUiTest {
        setContent {
            MainScreen()
        }
        onNodeWithText("You have pushed the button this many times").assertExists()
        onNodeWithText("0").assertExists()
        onNodeWithContentDescription("Increment").performClick()
        onNodeWithText("1").assertExists()

    }

    @Test
    fun myFirstTestWithTags() = runComposeUiTest {
        setContent {
            MainScreen()
        }
        onNodeWithTag(MainScreenTags.HINT_TEXT).assertTextEquals(
            "You have pushed the button this many times"
        )
        onNodeWithTag(MainScreenTags.COUNTER_TEXT).assertTextEquals(
            "0"
        )
        onNodeWithTag(MainScreenTags.INCREMENT_BUTTON).performClick()
        onNodeWithTag(MainScreenTags.COUNTER_TEXT).assertTextEquals(
            "1"
        )
    }
}