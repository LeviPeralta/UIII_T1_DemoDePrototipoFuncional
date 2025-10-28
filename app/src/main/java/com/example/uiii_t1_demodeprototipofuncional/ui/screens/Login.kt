package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.ui.components.buttons.Boton
import com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel.AuthViewModel

@Composable
fun Login(navController: NavHostController, authVM: AuthViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        // Campo de correo
        TextField(
            value = authVM.username.value,
            onValueChange = { authVM.username.value = it },
            label = { Text("Ingresa tu correo") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de contraseña
        TextField(
            value = authVM.password.value,
            onValueChange = { authVM.password.value = it },
            label = { Text("Ingresa tu contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        // Links de recuperación y registro
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                "¿Olvidaste tu contraseña?",
                modifier = Modifier.clickable { navController.navigate("recupera") }
            )
            Text(
                "Regístrate",
                modifier = Modifier.clickable { navController.navigate("registro") }
            )
        }

        // Botón de iniciar sesión
        Boton("Iniciar sesión") {
            if (authVM.login()) {
                navController.navigate("tienda")
            }
        }

        // Mostrar error si existe
        if (authVM.errorMessage.value.isNotEmpty()) {
            Text(text = authVM.errorMessage.value)
        }
    }
}
