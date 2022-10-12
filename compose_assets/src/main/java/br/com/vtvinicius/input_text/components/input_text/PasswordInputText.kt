import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.input_text.R
import br.com.vtvinicius.input_text.utils.RegexEnum
import br.com.vtvinicius.input_text.utils.Validation

@Composable
fun PasswordInputText(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
    state: InputTextState = InputTextState.PASSWORD,
    showError: Boolean = true
) {

    var currentState: InputTextState = state

    val styleType: InputTextStyleType = InputTextStyleType.PASSWORD

    var passwordVisualTransformation: VisualTransformation by remember {
        mutableStateOf(PasswordVisualTransformation())
    }

    var error = remember { mutableStateOf(false) }

    LaunchedEffect(LocalContext.current) {
        currentState.getPasswordIcon(R.drawable.ic_eye_closed)
    }

    if (showError) {
        when (error.value) {
            true -> {
                currentState = InputTextState.PASSWORD_ERROR
                styleType.getErrorMessage("Sua senha deve conter no minimo 6 digitos, Letras Maiúsculas, Minúsculas, Números e Símbolos")
            }
            false -> {
                currentState = InputTextState.PASSWORD
                styleType.getErrorMessage("")
            }
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "Senha",
        state = currentState,
        mask = passwordVisualTransformation,
        maxLength = 100,
        inputType = RegexEnum.ALL,
        styleType = styleType,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        onIconClick = {
            if (passwordVisualTransformation is PasswordVisualTransformation) {
                passwordVisualTransformation = VisualTransformation.None
                currentState.getPasswordIcon(R.drawable.ic_eye_open)
            } else {
                passwordVisualTransformation = PasswordVisualTransformation()
                currentState.getPasswordIcon(R.drawable.ic_eye_closed)
            }
        },
        onSearch = {
            onSearch(it)
            when (Validation().validatePassword(it)) {
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
//fun PasswordInputTextPreview() {
//    Box(
//        Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp)
//    ) {
//        PasswordInputText(onSearch = {})
//
//    }
//}