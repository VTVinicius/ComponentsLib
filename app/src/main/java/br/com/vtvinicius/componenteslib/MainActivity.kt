package br.com.vtvinicius.componenteslib

import ComposeThemes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeThemes() {
                Preview()
            }
        }
    }
}

