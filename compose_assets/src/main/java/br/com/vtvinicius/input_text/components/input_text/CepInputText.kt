import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.vtvinicius.input_text.utils.Mask
import br.com.vtvinicius.input_text.utils.RegexEnum

@Composable
fun CepInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.OUTLINE,
    onSearch: (String) -> Unit,
    hint: String = "CEP",
    errorMessage :String = "CEP inválido"
) {
    val styleType: InputTextStyleType = remember { InputTextStyleType.CEP }

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
        mask = Mask.buildCEP(),
        maxLength = 8,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            when (it.length < 8) {
                true -> {
                    error.value = true
                }
                false -> {
                    error.value = false
                    onSearch(it)
                }
            }

        }
    )
}
