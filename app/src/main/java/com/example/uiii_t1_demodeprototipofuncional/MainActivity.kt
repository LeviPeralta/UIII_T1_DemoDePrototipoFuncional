package com.example.uiii_t1_demodeprototipofuncional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.uiii_t1_demodeprototipofuncional.ui.navigation.AppNavigation
import com.example.uiii_t1_demodeprototipofuncional.ui.theme.UIII_T1_DemoDePrototipoFuncionalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIII_T1_DemoDePrototipoFuncionalTheme {
                // Se crea el controlador de navegación
                val navController = rememberNavController()

                // Se inicia la navegación principal
                AppNavigation(navController = navController)
            }
            }
        }
}