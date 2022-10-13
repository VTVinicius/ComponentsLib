import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.vtvinicius.input_text.utils.Mask
import br.com.vtvinicius.input_text.utils.RegexEnum
import br.com.vtvinicius.input_text.utils.Validation

@Composable
fun CNPJInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit
) {
    val styleType: InputTextStyleType = InputTextStyleType.CNPJ

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage("CNPJ inválido")
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "CNPJ",
        state = currentState,
        mask = Mask.buildCNPJ(),
        maxLength = 14,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            onSearch(it)
            when (Validation().isValidCNPJ(it)) {
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
