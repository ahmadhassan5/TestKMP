package com.ahmadhassan.testkmp

import androidx.compose.ui.window.Application
import com.ahmadhassan.testkmp.home_setting.HomeSettingScreen

fun MainViewController() = Application("My iOS") {
    HomeSettingScreen()
}