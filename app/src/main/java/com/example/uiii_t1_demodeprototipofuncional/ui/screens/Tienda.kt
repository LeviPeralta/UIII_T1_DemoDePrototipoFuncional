package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.ui.components.RecomendadosCard
import com.example.uiii_t1_demodeprototipofuncional.ui.components.JuegosPopularesCard
import com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel.JuegosViewModel

@Composable
fun Tienda(navController: NavHostController, juegosVM: JuegosViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🎮 Juegos Recomendados", modifier = Modifier.padding(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(juegosVM.recomendados) { juego ->
                RecomendadosCard(juego) {
                    // acción al hacer clic (por ejemplo, mostrar detalles)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("🔥 Juegos Populares", modifier = Modifier.padding(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(juegosVM.populares) { juego ->
                JuegosPopularesCard(juego) {
                    // acción al hacer clic (por ejemplo, abrir detalles)
                }
            }
        }
    }
}
