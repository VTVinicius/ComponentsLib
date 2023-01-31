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
import br.com.vtvinicius.input_text.utils.Validation

@Composable
fun EmailInputTextLib(
    modifier: Modifier = Modifier,
    state: InputTextStateLib = InputTextStateLib.OUTLINE,
    onSearch: (String) -> Unit,
    hint: String = "E-mail",
    maxLength : Int = 100,
    errorMessage: String = "E-mail inválido",
) {
    val styleType: InputTextStyleTypeLib = InputTextStyleTypeLib.EMAIL

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
        mask = VisualTransformation.None,
        maxLength = maxLength,
        styleType = styleType,
        inputType = RegexEnum.ALL,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = {
            when (Validation().validateEmail(it)) {
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
