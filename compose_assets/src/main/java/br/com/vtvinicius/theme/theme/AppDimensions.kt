package br.com.vtvinicius.theme.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val paddingSmall: Dp = 4.dp,
    val paddingMedium: Dp = 8.dp,
    val paddingLarge: Dp = 16.dp,
    val small: RoundedCornerShape = RoundedCornerShape(4.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(4.dp),
    val large: RoundedCornerShape = RoundedCornerShape(0.dp),
    val defaultSize: RoundedCornerShape = RoundedCornerShape(10.dp),
    val rounded: RoundedCornerShape = RoundedCornerShape(110.dp)
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }