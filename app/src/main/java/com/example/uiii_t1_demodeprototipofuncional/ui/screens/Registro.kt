package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.data.Repository
import com.example.uiii_t1_demodeprototipofuncional.data.Usuario
import com.example.uiii_t1_demodeprototipofuncional.ui.components.buttons.Boton

@Composable
fun Registro(navController: NavHostController) {
    val context = LocalContext.current
    val repo = remember { Repository(context) }

    var nombre by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmar by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Ingresa tu nombre") })
            TextField(value = fecha, onValueChange = { fecha = it }, label = { Text("Ingresa tu fecha de nacimiento") })
            TextField(value = correo, onValueChange = { correo = it }, label = { Text("Ingresa tu correo") })
            TextField(value = contrasena, onValueChange = { contrasena = it }, label = { Text("Ingresa tu contraseña") })
            TextField(value = confirmar, onValueChange = { confirmar = it }, label = { Text("Confirma tu contraseña") })
            TextField(value = telefono, onValueChange = { telefono = it }, label = { Text("Ingresa tu número de teléfono") })
        }

        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
        ) {
            Boton("Iniciar sesión con Google") { }
            Boton("Iniciar sesión con Correo") { }

            Boton("Iniciar sesión") {
                if (nombre.isBlank() || correo.isBlank() || contrasena.isBlank()) {
                    Toast.makeText(context, "Completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
                } else if (contrasena != confirmar) {
                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                } else {
                    repo.insertUsuario(
                        Usuario(
                            nombre = nombre,
                            fechaNacimiento = fecha,
                            correo = correo,
                            contrasena = contrasena,
                            telefono = telefono
                        )
                    )
                    Toast.makeText(context, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                    navController.navigate("tienda")
                }
            }
        }
    }
}
