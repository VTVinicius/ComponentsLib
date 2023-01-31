import ComposeTheme.typography
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.input_text.R
import br.com.vtvinicius.input_text.utils.HorizontalSpacer
import br.com.vtvinicius.input_text.utils.RegexEnum
import br.com.vtvinicius.input_text.utils.VerticalSpacer
import br.com.vtvinicius.input_text.utils.unmask
import java.text.NumberFormat
import java.util.*


@Composable
fun BaseInputText(
    modifier: Modifier = Modifier,
    hint: String = "",
    mask: VisualTransformation? = null,
    maxLength: Int? = null,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit = {},
    onIconClick: () -> Unit = {},
    isMoney: Boolean = false,
    inputType: RegexEnum? = null,
    styleType: InputTextStyleType = InputTextStyleType.NOTHING,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
) {

    val LOCALE_PT_BR = Locale("pt", "BR")

    val mFormatter: NumberFormat = NumberFormat.getCurrencyInstance(LOCALE_PT_BR)

    var mIsUpdating: Boolean = false

    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    var isFieldEmpty by remember {
        mutableStateOf(true)
    }

    val textFieldValue = remember {
        mutableStateOf(
            TextFieldValue(
                text = text,
                selection = TextRange(0)
            )
        )

    }

    Column {
        Box(
            modifier = modifier
        ) {
            TextField(
                value = textFieldValue.value,
                onValueChange = {
                    if (isMoney) {
                        if (!mIsUpdating && it.text.unmask().matches(inputType?.value ?: RegexEnum.ALL.value)) {
                            mIsUpdating = true
                            val cleanString = it.text.unmask()
                            val parsed = cleanString.toDouble()
                            val formatted = mFormatter.format(parsed / 100)
                            text = formatted
                            mIsUpdating = false

                            textFieldValue.value = TextFieldValue(
                                text = text,
                                selection = TextRange(text.length)
                            )
                            isFieldEmpty = it.text == ""
                        }
                    } else {
                        if (it.text.length > (maxLength ?: 0)) {
                            return@TextField
                        } else if (it.text.matches(inputType?.value ?: RegexEnum.ALL.value)) {
                            textFieldValue.value = it
                            onSearch(it.text)
                            isFieldEmpty = it.text == ""
                        } else if (it.text.length < textFieldValue.value.text.length) {
                            textFieldValue.value = it
                            isFieldEmpty = it.text == ""
                        }
                    }

                },
                visualTransformation =
                if (mask != null && mask is PasswordVisualTransformation) {
                    PasswordVisualTransformation()
                } else mask ?: VisualTransformation.None,
                trailingIcon =
                {
                    if (state.rightIcon != null) {
                        IconButton(
                            onClick = {
                                onIconClick()
                            }
                        ) {

                            Icon(
                                painter = painterResource(id = state.rightIcon!!),
                                contentDescription = "visibility Icon"
                            )
                        }
                    } else {
                        onIconClick()
                    }
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = state.getBackgroundColor(),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = ComposeTheme.dimensions.defaultSize,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = state.getBorderSize(),
                        color = state.getBorderColor(),
                        shape = ComposeTheme.dimensions.defaultSize,
                    )
                    .background(
                        state.getBackgroundColor(),
                        ComposeTheme.dimensions.defaultSize
                    )
                    .onFocusChanged {
                        if (isFieldEmpty) {
                            isHintDisplayed = it.isFocused != true
                        } else {
                            isHintDisplayed = false
                        }
                    },

                )
            if (isHintDisplayed) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        modifier = modifier,
                        textAlign = TextAlign.Center,
                        text = hint,
                        style = TextStyle(
                            fontFamily = typography.normalSmallBold.fontFamily,
                            color = gray
                        ),
                        fontSize = typography.normalSmallBold.fontSize,
                        fontWeight = typography.normalSmallBold.fontWeight
                    )
                }
            }
        }

            VerticalSpacer(height = 2)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (styleType.errorMessage != "") {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_error_alert),
                        tint = red,
                        modifier = Modifier.size(16.dp),
                        contentDescription = "Error Icon"
                    )

                    HorizontalSpacer(width = 4)

                    Text(
                        textAlign = TextAlign.Start,
                        text = styleType.errorMessage,
                        style = TextStyle(
                            fontFamily = typography.normalSmall.fontFamily,
                            color = red
                        ),
                        fontSize = typography.normalSmall.fontSize,
                        fontWeight = typography.normalSmall.fontWeight
                    )
                }
            }
        }

}

