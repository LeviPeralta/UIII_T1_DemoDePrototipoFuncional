package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.data.DbHelper
import com.example.uiii_t1_demodeprototipofuncional.data.Usuario

@Composable
fun EditarUsuarioScreen(navController: NavHostController, usuario: Usuario) {
    val context = LocalContext.current
    val db = remember { DbHelper(context) }

    var nombre by remember { mutableStateOf(usuario.nombre) }
    var fechaNacimiento by remember { mutableStateOf(usuario.fechaNacimiento) }
    var correo by remember { mutableStateOf(usuario.correo) }
    var contrasena by remember { mutableStateOf(usuario.contrasena) }
    var telefono by remember { mutableStateOf(usuario.telefono) }

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Editar Usuario", style = MaterialTheme.typography.titleLarge)

        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = fechaNacimiento, onValueChange = { fechaNacimiento = it }, label = { Text("Fecha de nacimiento") })
        TextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") })
        TextField(value = contrasena, onValueChange = { contrasena = it }, label = { Text("Contraseña") })
        TextField(value = telefono, onValueChange = { telefono = it }, label = { Text("Teléfono") })

        Button(
            onClick = {
                val actualizado = Usuario(usuario.id, nombre, fechaNacimiento, correo, contrasena, telefono)
                db.updateUsuario(actualizado)
                navController.navigate("usuarios")
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Actualizar")
        }

        Button(
            onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Eliminar")
        }
    }

    // Alerta de confirmación para eliminar
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    db.deleteUsuario(usuario.id)
                    showDialog = false
                    navController.navigate("usuarios")
                }) {
                    Text("Sí, eliminar", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            },
            title = { Text("Confirmar eliminación") },
            text = { Text("¿Deseas eliminar este usuario? Esta acción no se puede deshacer.") }
        )
    }
}
