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
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit,
    editText: EditText? = null,
) {

    val LOCALE_PT_BR = Locale("pt", "BR")
    val mFormatter: NumberFormat = NumberFormat.getCurrencyInstance(LOCALE_PT_BR)
    var mIsUpdating: Boolean = false

    val styleType: InputTextStyleType = InputTextStyleType.NOTHING

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage("Nome incompleto")
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "Dinheiro",
        state = currentState,
        maxLength = 69,
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