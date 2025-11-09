package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.data.DbHelper
import com.example.uiii_t1_demodeprototipofuncional.data.Usuario

@Composable
fun PrincipalScreen(navController: NavHostController) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val db = remember { DbHelper(context) }
    val usuarios = remember { mutableStateListOf<Usuario>() }

    // Cargar datos al iniciar
    LaunchedEffect(Unit) {
        usuarios.clear()
        usuarios.addAll(db.getAllUsuarios())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Usuarios registrados",
            style = MaterialTheme.typography.titleLarge
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(usuarios) { usuario ->
                UsuarioCard(usuario)
            }
        }
    }
}

@Composable
fun UsuarioCard(usuario: Usuario) {
    Card(
        modifier = Modifier.fillMaxSize(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = "👤 ${usuario.nombre}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "📧 ${usuario.correo}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "📞 ${usuario.telefono}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
