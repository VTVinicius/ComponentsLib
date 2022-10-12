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
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit
) {
    val styleType: InputTextStyleType = InputTextStyleType.NAME

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
        hint = "Nome",
        state = currentState,
        maxLength = 69,
        styleType = styleType,
        inputType = RegexEnum.LETTERS,
        mask = VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = {
            onSearch(it)
            when (Validation().validateName(it) && !it.contains("  ")) {
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

//@Preview
//@Composable
//fun NameInputTextPreview() {
//    Column(
//        Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp)
//    ) {
//        VerticalSpacer(height = 16)
//        NameInputText{}
//    }
//}