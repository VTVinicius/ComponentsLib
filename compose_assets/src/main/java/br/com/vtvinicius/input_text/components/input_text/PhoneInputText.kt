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
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit
) {

    val styleType: InputTextStyleType = InputTextStyleType.PHONE

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage("Digite um número de telefone válido")
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "Telefone",
        state = currentState,
        mask = Mask.buildPhone(),
        maxLength = 11,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            onSearch(it)
            error.value = it.length < 11
        }
    )
}

//@Preview
//@Composable
//fun PhoneInputTextPreview() {
//    Box(
//        Modifier
//            .fillMaxSize()
//            .background(Color.Red)
//            .padding(16.dp)
//    ) {
//        PhoneInputText(
//            state = InputTextState.NORMAL,
//            onSearch = {}
//        )
//    }
//}