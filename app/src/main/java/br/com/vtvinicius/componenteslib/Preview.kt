package br.com.vtvinicius.componenteslib

import BasicInputText
import CPFInputText
import CepInputText
import ComposeTheme.typography
import EmailInputText
import MoneyInputText
import NameInputText
import OnlyLettersInputText
import OnlyNumbersInputText
import PasswordInputText
import PhoneInputText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import background
import br.com.vtvinicius.input_text.utils.VerticalSpacer

@Composable
fun Preview(){

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(background)
            .padding(32.dp)

    ) {


        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Campos de Texto",
                style = TextStyle(
                    fontFamily = typography.title20Bold.fontFamily,
                    color = Color.Black
                ),
                fontSize = typography.title20Bold.fontSize,
                fontWeight = typography.title20Bold.fontWeight
            )
        }

        VerticalSpacer(height = 24)

        MoneyInputText(onSearch = {})

        VerticalSpacer(height = 24)

        SubtitleText(text = "Input de Texto para CEP.")

        VerticalSpacer(height = 8)

        CepInputText(onSearch = {}, state = InputTextState.NORMAL)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para CPF.")

        VerticalSpacer(height = 8)

        CPFInputText(onSearch = {}, state = InputTextState.GRAY)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Email.")

        VerticalSpacer(height = 8)

        EmailInputText(onSearch = {}, state = InputTextState.OUTLINE)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Nome.")

        VerticalSpacer(height = 8)

        NameInputText(onSearch = {}, state = InputTextState.NORMAL)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Senha.")

        VerticalSpacer(height = 8)

        PasswordInputText(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Celular.")

        VerticalSpacer(height = 8)

        PhoneInputText(onSearch = {}, state = InputTextState.GRAY)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto que aceita apenas Letras.")

        VerticalSpacer(height = 8)

        OnlyLettersInputText(maxLength = 60, onSearch = {}, state = InputTextState.OUTLINE)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto que aceita apenas Numeros.")

        VerticalSpacer(height = 8)

        OnlyNumbersInputText(maxLength = 10, onSearch = {}, state = InputTextState.NORMAL)

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto basico, sem validações.")

        VerticalSpacer(height = 8)

        BasicInputText(maxLength = 100, onSearch = {}, state = InputTextState.GRAY)

    }



}


@Composable
fun SubtitleText(text: String, textColor: Int = R.color.black) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = typography.subtitle.fontFamily,
            color = colorResource(id = textColor)
        )
    )
}