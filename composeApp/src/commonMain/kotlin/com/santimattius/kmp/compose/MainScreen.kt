package com.santimattius.kmp.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.santimattius.kmp.compose.core.ui.components.AppBar

object MainScreenTags{
    const val INCREMENT_BUTTON = "IncrementButton"
    const val COUNTER_TEXT = "CounterText"
    const val HINT_TEXT = "HintText"
}

@Composable
fun MainScreen() {
    var incrementCounter by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            AppBar(title = "UI Testing in Compose Multiplatform")
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.testTag(MainScreenTags.INCREMENT_BUTTON),
                onClick = {
                    incrementCounter += 1
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Increment"
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.testTag(MainScreenTags.HINT_TEXT),
                text = "You have pushed the button this many times"
            )
            Text(
                modifier = Modifier.testTag(MainScreenTags.COUNTER_TEXT),
                text = "$incrementCounter",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}