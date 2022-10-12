package br.com.vtvinicius.input_text.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HorizontalSpacer(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}

@Composable
fun VerticalSpacer(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}