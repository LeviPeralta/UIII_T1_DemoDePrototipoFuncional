package com.example.uiii_t1_demodeprototipofuncional.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uiii_t1_demodeprototipofuncional.ui.screens.*
import com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel.*

@Composable
fun AppNavigation(navController: NavHostController) {
    // Creamos los ViewModel que se compartirán entre pantallas
    val authVM: AuthViewModel = viewModel()
    val juegosVM: JuegosViewModel = viewModel()

    // Definición del grafo de navegación
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        // Pantalla de inicio de sesión
        composable("login") {
            Login(navController = navController, authVM = authVM)
        }

        // Pantalla de registro (sin funcionalidad)
        composable("registro") {
            Registro(navController = navController)
        }

        // Pantalla de recuperación de contraseña (sin funcionalidad)
        composable("recupera") {
            RecuperaContra(navController = navController)
        }

        // Pantalla principal (tienda)
        composable("tienda") {
            Tienda(navController = navController, juegosVM = juegosVM)
        }

        // Pantalla de biblioteca
        composable("biblioteca") {
            Biblioteca(navController = navController, juegosVM = juegosVM)
        }
    }
}