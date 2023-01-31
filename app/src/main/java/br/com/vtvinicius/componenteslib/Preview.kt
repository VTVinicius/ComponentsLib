package br.com.vtvinicius.componenteslib

import br.com.vtvinicius.input_text.components.input_text.BasicInputTextLib
import br.com.vtvinicius.input_text.components.input_text.CNPJInputTextLib
import br.com.vtvinicius.input_text.components.input_text.CPFInputTextLib
import br.com.vtvinicius.input_text.components.input_text.CepInputTextLib
import br.com.vtvinicius.theme.theme.ComposeTheme.typography
import br.com.vtvinicius.input_text.components.input_text.DateInputTextLib
import br.com.vtvinicius.input_text.components.input_text.EmailInputTextLib
import br.com.vtvinicius.input_text.components.input_text.MoneyInputTextLib
import br.com.vtvinicius.input_text.components.input_text.NameInputTextLib
import br.com.vtvinicius.input_text.components.input_text.OnlyLettersInputTextLib
import br.com.vtvinicius.input_text.components.input_text.OnlyNumbersInputTextLib
import br.com.vtvinicius.input_text.components.input_text.PasswordInputTextLib
import br.com.vtvinicius.input_text.components.input_text.PhoneInputTextLib
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
import br.com.vtvinicius.theme.theme.background
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

        MoneyInputTextLib(onSearch = {})

        VerticalSpacer(height = 24)

        SubtitleText(text = "Input de Texto para CEP.")

        VerticalSpacer(height = 8)

        CepInputTextLib(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para CPF.")

        VerticalSpacer(height = 8)

        CPFInputTextLib(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Email.")

        VerticalSpacer(height = 8)

        EmailInputTextLib(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Nome.")

        VerticalSpacer(height = 8)

        NameInputTextLib(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Senha.")

        VerticalSpacer(height = 8)

        PasswordInputTextLib(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto para Celular.")

        VerticalSpacer(height = 8)

        PhoneInputTextLib(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto que aceita apenas Letras.")

        VerticalSpacer(height = 8)

        OnlyLettersInputTextLib(maxLength = 60, onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto que aceita apenas Numeros.")

        VerticalSpacer(height = 8)

        OnlyNumbersInputTextLib(maxLength = 10, onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Texto basico, sem validações.")

        VerticalSpacer(height = 8)

        BasicInputTextLib(maxLength = 100, onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de CNPJ.")

        VerticalSpacer(height = 8)

        CNPJInputTextLib(onSearch = {})

        VerticalSpacer(height = 16)

        SubtitleText(text = "Input de Data.")

        VerticalSpacer(height = 8)

        DateInputTextLib(onSearch = { println("Teste: $it") })

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