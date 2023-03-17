package com.ahmadhassan.testkmp.utils

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.desc

@Composable
actual fun stringResource(res: StringResource) = res.desc().localized()