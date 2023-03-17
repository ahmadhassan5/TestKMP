package com.ahmadhassan.testkmp.utils

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource

@Composable
actual fun stringResource(res: StringResource) = androidx.compose.ui.res.stringResource(res.resourceId)