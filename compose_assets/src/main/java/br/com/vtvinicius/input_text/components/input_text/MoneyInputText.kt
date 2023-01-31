import android.widget.EditText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.utils.RegexEnum
import java.text.NumberFormat
import java.util.*

@Composable
fun MoneyInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.OUTLINE,
    onSearch: (String) -> Unit,
    hint: String = "Dinheiro",
    maxLength: Int = 14,
    errorMessage: String = "Valor inválido",
) {
    val styleType: InputTextStyleType = InputTextStyleType.NOTHING

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
        inputType = RegexEnum.NUMBERS,
        mask = VisualTransformation.None,
        isMoney = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            onSearch(it)
        }
    )
}