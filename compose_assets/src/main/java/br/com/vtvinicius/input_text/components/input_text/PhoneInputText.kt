import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.vtvinicius.input_text.utils.Mask
import br.com.vtvinicius.input_text.utils.RegexEnum

@Composable
fun PhoneInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.OUTLINE,
    onSearch: (String) -> Unit,
    hint: String = "Telefone",
    errorMessage: String = "Telefone inválido",
) {

    val styleType: InputTextStyleType = InputTextStyleType.PHONE

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
        mask = Mask.buildPhone(),
        maxLength = 11,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {

            if (it.length < 11) {
                error.value = true
            } else {
                error.value = false
                onSearch(it)
            }

        }
    )
}