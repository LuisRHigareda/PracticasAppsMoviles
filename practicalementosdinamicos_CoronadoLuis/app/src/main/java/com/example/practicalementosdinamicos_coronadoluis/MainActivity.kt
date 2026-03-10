package com.example.practicalementosdinamicos_coronadoluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.practicalementosdinamicos_coronadoluis.ui.screens.LoginScreen
import com.example.practicalementosdinamicos_coronadoluis.ui.theme.Practicalementosdinamicos_CoronadoLuisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Practicalementosdinamicos_CoronadoLuisTheme {
                LoginScreen()
            }
        }
    }
}