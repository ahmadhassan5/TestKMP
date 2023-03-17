package com.ahmadhassan.testkmp.home_setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import shared_resources.MR

/**
 * Created by Ahmad Hassan on 02/01/2023.
 */

@Composable
internal fun HomeSettingScreen(
//    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeSettingViewModel = HomeSettingViewModel(),
) {

    println("s:${
        StringDesc.Resource(MR.strings.ayaat)
    }")
    val isArabicEnabled by viewModel.isArabicEnabled.collectAsState(true)
    val isTranslationEnabled by viewModel.isTranslationEnabled.collectAsState(true)
    val isHashiyaEnabled by viewModel.isHashiyaEnabled.collectAsState(true)
    val selectedView by viewModel.selectedView.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "stringResource(id = R.string.settings)") },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "stringResource(R.string.go_back)"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            HomeSettingItem(
                text = "stringResource(id = R.string.arabic)",
                checked = isArabicEnabled,
                onCheckedChange = {  }
            )
            HomeSettingItem(
                text = "stringResource(id = R.string.translation)",
                checked = isTranslationEnabled,
                onCheckedChange = viewModel::onTranslationChange
            )
            HomeSettingItem(
                text = "stringResource(id = R.string.hashiya)",
                checked = isHashiyaEnabled,
                onCheckedChange = {  }
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "stringResource(R.string.recitation_options)",
                fontWeight = FontWeight.Bold,
//                fontFamily = Nafees,
                style = MaterialTheme.typography.subtitle1,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                horizontalArrangement = Arrangement.Start,
                verticalArrangement = Arrangement.spacedBy(3.dp),
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Adaptive(140.dp)
            ) {

                items(items = listOf(
                    "RecitationOptions.ByPage",
                    "RecitationOptions.ByParah",
                    "RecitationOptions.BySurah",
                )) { option ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = "option.name" == selectedView,
                            ) { /*viewModel.onViewChange(option)*/ }
                            .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            selected = "option.name" == selectedView,
                            onClick = null,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Text(text = "stringResource(id = getResId(option.titleId, R.string::class.java)"
                            /*LocalContext.current.resources.getIdentifier(option.title, "string", LocalContext.current.packageName)*/)
                    }
                }
            }
        }
    }
}

@Composable
internal fun HomeSettingItem(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
//            fontFamily = Nafees,
            fontWeight = FontWeight.Bold
        )
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}