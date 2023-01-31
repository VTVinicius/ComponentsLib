package br.com.vtvinicius.theme.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    primary: Color,
    textPrimary: Color,
    textSecondary: Color,
    background: Color,
    error: Color,
    success: Color,
    isLight: Boolean,
) {
    var primary by mutableStateOf(primary)
    var textSecondary by mutableStateOf(textSecondary)
    var textPrimary by mutableStateOf(textPrimary)
    var error by mutableStateOf(error)
    var background by mutableStateOf(background)
    var success by mutableStateOf(success)
    var isLight by mutableStateOf(isLight)

    fun copy(
        primary: Color = this.primary,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        error: Color = this.error,
        background: Color = this.background,
        success: Color = this.success,
        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        primary,
        textPrimary,
        textSecondary,
        error,
        background,
        success,
        isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        background = other.background
        error = other.error
    }
}

private val colorPrimary = Color(0xFF000000)
private val colorTextPrimary = Color(0xFF323F4B)
private val colorTextSecondary = Color(0xFF556F97)
private val colorBackground = Color(0xFFF6F6F6)
private val colorError = Color(0xFFBC2F2F)
private val colorSuccess = Color(0xFF008423)

fun lightColors(
    primary: Color = colorPrimary,
    textPrimary: Color = colorTextPrimary,
    textSecondary: Color = colorTextSecondary,
    background: Color = colorBackground,
    error: Color = colorError,
    success: Color = colorSuccess
): AppColors = AppColors(
    primary = primary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    background = background,
    error = error,
    success = success,
    isLight = true
)

val LocalColors = staticCompositionLocalOf { lightColors() }

val gray = Color(0xFF515151)
var red = Color(0xFFFF0000)
val inputTextGrey = Color(0XFFEBEBEB)
val background = Color(0XFFF6F6F6)