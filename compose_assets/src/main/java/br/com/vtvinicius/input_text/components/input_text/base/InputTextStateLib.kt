package br.com.vtvinicius.input_text.components.input_text.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.theme.theme.gray
import br.com.vtvinicius.theme.theme.inputTextGrey
import br.com.vtvinicius.theme.theme.red


enum class InputTextStateLib(val value: Int) {
    NORMAL(0),
    OUTLINE(1),
    GRAY(2),
    ERROR(3),
    PASSWORD(4),
    PASSWORD_ERROR(5);

    var rightIcon: Int? = null
    var textValue: String = ""

    @Composable
    fun getBorderColor(): Color = when (value) {
        OUTLINE.value -> gray
        ERROR.value -> red
        PASSWORD.value -> gray
        PASSWORD_ERROR.value -> red
        else -> Color.Transparent
    }

    @Composable
    fun getBorderSize(): Dp = when (value) {
        OUTLINE.value -> 1.dp
        ERROR.value -> 1.dp
        PASSWORD.value -> 1.dp
        PASSWORD_ERROR.value -> 1.dp
        else -> 0.dp
    }

    @Composable
    fun getBackgroundColor(): Color = when (value) {
        GRAY.value -> inputTextGrey
        else -> Color.White
    }

    fun getPasswordIcon(icon: Int?) = when (value) {
        PASSWORD.value -> rightIcon = icon
        PASSWORD_ERROR.value -> rightIcon = icon
        else -> rightIcon = null
    }
}