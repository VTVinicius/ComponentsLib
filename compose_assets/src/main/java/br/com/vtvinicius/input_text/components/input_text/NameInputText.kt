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
fun NameInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.OUTLINE,
    onSearch: (String) -> Unit,
    hint: String = "Nome",
    maxLength : Int = 69,
    errorMessage: String = "Nome inválido",
) {
    val styleType: InputTextStyleType = InputTextStyleType.NAME

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage(errorMessage)
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = hint,
        state = currentState,
        maxLength = maxLength,
        styleType = styleType,
        inputType = RegexEnum.LETTERS,
        mask = VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = {
            when (Validation().validateName(it) && !it.contains("  ")) {
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