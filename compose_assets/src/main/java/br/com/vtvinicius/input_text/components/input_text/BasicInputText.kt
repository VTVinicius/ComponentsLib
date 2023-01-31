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
fun BasicInputTextLib(
    modifier: Modifier = Modifier,
    state: InputTextStateLib = InputTextStateLib.OUTLINE,
    hint: String = "",
    maxLength: Int,
    onSearch: (String) -> Unit,
    inputType: RegexEnum = RegexEnum.ALL,
) {
    BaseInputTextLib(
        modifier = modifier,
        hint = hint,
        state = state,
        mask = VisualTransformation.None,
        maxLength = maxLength,
        inputType = inputType,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = onSearch
    )

}
