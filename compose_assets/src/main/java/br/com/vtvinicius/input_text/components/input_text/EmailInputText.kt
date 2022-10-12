import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.utils.RegexEnum
import br.com.vtvinicius.input_text.utils.Validation

@Composable
fun EmailInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit
) {
    val styleType: InputTextStyleType = InputTextStyleType.EMAIL

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage("E-mail inválido")
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "E-mail",
        state = currentState,
        mask = VisualTransformation.None,
        maxLength = 100,
        styleType = styleType,
        inputType = RegexEnum.ALL,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = {
            onSearch(it)
            when (Validation().validateEmail(it)) {
                true -> {
                    error.value = false
                }
                false -> {
                    error.value = true
                }
            }
        }
    )
}
