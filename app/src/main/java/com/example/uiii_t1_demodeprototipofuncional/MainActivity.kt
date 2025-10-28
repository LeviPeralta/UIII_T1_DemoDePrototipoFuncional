package com.example.uiii_t1_demodeprototipofuncional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.uiii_t1_demodeprototipofuncional.ui.Navigation
import com.example.uiii_t1_demodeprototipofuncional.ui.theme.UIII_T1_DemoDePrototipoFuncionalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIII_T1_DemoDePrototipoFuncionalTheme {
                Navigation()
            }
        }
    }
}