package br.com.vtvinicius.input_text.components.input_text

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.vtvinicius.input_text.components.input_text.base.BaseInputTextLib
import br.com.vtvinicius.input_text.components.input_text.base.InputTextStateLib
import br.com.vtvinicius.input_text.components.input_text.base.InputTextStyleTypeLib
import br.com.vtvinicius.input_text.utils.Mask
import br.com.vtvinicius.input_text.utils.RegexEnum
import br.com.vtvinicius.input_text.utils.Validation

@Composable
fun CPFInputTextLib(
    modifier: Modifier = Modifier,
    state: InputTextStateLib = InputTextStateLib.OUTLINE,
    onSearch: (String) -> Unit,
    hint: String = "CPF",
    errorMessage: String = "CPF inválido",
) {
    val styleType: InputTextStyleTypeLib = InputTextStyleTypeLib.CPF

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
        mask = Mask.buildCpf(),
        maxLength = 11,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            when (Validation().validateCPF(it)) {
                true -> {
                    error.value = false
                    onSearch(it)
                }
                false -> {
                    error.value = true
                }
            }
        }
    )
}
