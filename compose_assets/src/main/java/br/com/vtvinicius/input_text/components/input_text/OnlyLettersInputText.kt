package br.com.vtvinicius.input_text.components.input_text

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.components.input_text.base.BaseInputTextLib
import br.com.vtvinicius.input_text.components.input_text.base.InputTextStateLib
import br.com.vtvinicius.input_text.utils.RegexEnum

@Composable
fun OnlyLettersInputTextLib(
    modifier: Modifier = Modifier,
    state: InputTextStateLib = InputTextStateLib.OUTLINE,
    hint: String = "",
    maxLength: Int,
    onSearch: (String) -> Unit
) {
    state.getPasswordIcon(null)

    BaseInputTextLib(
        modifier = modifier,
        hint = hint,
        state = state,
        mask = VisualTransformation.None,
        maxLength = maxLength,
        inputType = RegexEnum.LETTERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = onSearch
    )
}
