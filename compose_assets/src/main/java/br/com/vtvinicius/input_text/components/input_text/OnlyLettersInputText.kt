import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.utils.RegexEnum

@Composable
fun OnlyLettersInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    hint: String = "",
    maxLength: Int,
    onSearch: (String) -> Unit
) {
    state.getPasswordIcon(null)

    BaseInputText(
        modifier = modifier,
        hint = hint,
        state = state,
        mask = VisualTransformation.None,
        maxLength = maxLength,
        inputType = RegexEnum.LETTERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onSearch = onSearch
    )
}

//@Preview
//@Composable
//fun OnlyLettersInputTextPreview() {
//    Box(
//        Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp)
//    ) {
//        OnlyLettersInputText(
//            state = InputTextState.NORMAL,
//            hint = "Campo Simples apenas Letras",
//            maxLength = 100,
//            onSearch = {}
//        )
//    }
//}