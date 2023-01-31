import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.utils.RegexEnum

@Composable
fun OnlyNumbersInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.OUTLINE,
    hint: String = "",
    maxLength: Int,
    onSearch: (String) -> Unit
) {
    state.getPasswordIcon(null)

    BaseInputText(
        modifier = modifier,
        hint = hint,
        state = state,
        mask = VisualTransformation.None,
        maxLength = maxLength,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = onSearch
    )
}
