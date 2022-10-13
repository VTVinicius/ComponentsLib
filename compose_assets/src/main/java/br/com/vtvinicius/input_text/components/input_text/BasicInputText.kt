import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.utils.RegexEnum

@Composable
fun BasicInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    hint: String = "",
    maxLength: Int,
    onSearch: (String) -> Unit,
    inputType: RegexEnum = RegexEnum.ALL,
) {
    BaseInputText(
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
