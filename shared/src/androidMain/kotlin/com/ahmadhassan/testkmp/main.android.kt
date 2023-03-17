package com.ahmadhassan.testkmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.ahmadhassan.testkmp.home_setting.HomeSettingScreen
import com.ahmadhassan.testkmp.home_setting.HomeSettingViewModel
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Utils

@Composable
fun Application(viewModel: HomeSettingViewModel) {
//    val viewModel = viewModels()
    /*val context = LocalContext.current
    Utils.resourcesForContext(context).getString(stringRes.resourceId)*/
    HomeSettingScreen(viewModel = viewModel)
}