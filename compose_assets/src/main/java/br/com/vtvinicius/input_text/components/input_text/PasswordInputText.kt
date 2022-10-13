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

// TypePassword = 0  -> Senha Forte
// TypePassword = 1  -> Senha Numerica


@Composable
fun PasswordInputText(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
    state: InputTextState = InputTextState.PASSWORD,
    showError: Boolean = true,
    typePassword: Int = 0,
    maxLength: Int = 30,
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

    var regexEnum: RegexEnum = RegexEnum.ALL
    var keyboardType = KeyboardType.Password

    when(typePassword) {
        0 -> {
            regexEnum = RegexEnum.ALL
            keyboardType = KeyboardType.Password
        }
        1 -> {
            regexEnum = RegexEnum.NUMBERS
            keyboardType = KeyboardType.NumberPassword
        }
        else -> {
            regexEnum = RegexEnum.ALL
            keyboardType = KeyboardType.Password
        }

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
        maxLength = maxLength,
        inputType = regexEnum,
        styleType = styleType,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
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
            when (typePassword) {
                0 -> {
                    when (Validation().validateStrongPassword(it)) {
                        true -> {
                            error.value = false
                        }
                        false -> {
                            error.value = true
                        }
                    }
                }
                1 -> {
                    when (Validation().validateNumberPassword(it)) {
                        true -> {
                            error.value = false
                        }
                        false -> {
                            error.value = true
                        }
                    }
                }
                else -> {
                    when (Validation().validateStrongPassword(it)) {
                        true -> {
                            error.value = false
                        }
                        false -> {
                            error.value = true
                        }
                    }
                }
            }
        }
    )
}