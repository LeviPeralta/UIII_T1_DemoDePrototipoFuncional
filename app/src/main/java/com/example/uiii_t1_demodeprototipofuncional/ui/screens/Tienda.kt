package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.ui.components.RecomendadosCard
import com.example.uiii_t1_demodeprototipofuncional.ui.components.JuegosPopularesCard
import com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel.JuegosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tienda(navController: NavHostController, juegosVM: JuegosViewModel) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("usuarios") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    text = "👥",
                    color = Color.White,
                    fontSize = 22.sp
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "🎮 Bienvenido a la Tienda",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Explora juegos populares y recomendados",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "⭐ Recomendados",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFFF8F8F8), shape = MaterialTheme.shapes.medium)
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(juegosVM.recomendados) { juego ->
                    RecomendadosCard(juego) {
                        // acción al hacer clic
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "🔥 Populares",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFF8F8F8), shape = MaterialTheme.shapes.medium)
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(juegosVM.populares) { juego ->
                    JuegosPopularesCard(juego) {
                        // acción al hacer clic
                    }
                }
            }
        }
    }
}
