package com.ahmadhassan.testkmp

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

@Composable
internal fun Hello() {
    Text("Hello")
}