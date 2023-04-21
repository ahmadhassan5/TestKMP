package com.ahmadhassan.testkmp.utils

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.desc

// before compose 1.4.0 we can't use public modifier for @Composable in ios, so we should use internal here
// without it you got Undefined symbols for architecture x86_64: "_kfun:com.ahmadhassan.testkmp.utils#stringResource(dev.icerock.moko.resources.StringResource){}kotlin.String"
@Composable
internal actual fun stringResource(res: StringResource) = res.desc().localized()
