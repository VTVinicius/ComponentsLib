package br.com.vtvinicius.input_text.components.input_text

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.components.input_text.base.BaseInputTextLib
import br.com.vtvinicius.input_text.components.input_text.base.InputTextStateLib
import br.com.vtvinicius.input_text.components.input_text.base.InputTextStyleTypeLib
import br.com.vtvinicius.input_text.utils.RegexEnum

@Composable
fun MoneyInputTextLib(
    modifier: Modifier = Modifier,
    state: InputTextStateLib = InputTextStateLib.OUTLINE,
    onSearch: (String) -> Unit,
    hint: String = "Dinheiro",
    maxLength: Int = 14,
    errorMessage: String = "Valor inválido",
) {
    val styleType: InputTextStyleTypeLib = InputTextStyleTypeLib.NOTHING

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextStateLib = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextStateLib.ERROR
            styleType.getErrorMessage(errorMessage)
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputTextLib(
        modifier = modifier,
        hint = hint,
        state = currentState,
        maxLength = maxLength,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        mask = VisualTransformation.None,
        isMoney = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            onSearch(it)
        }
    )
}