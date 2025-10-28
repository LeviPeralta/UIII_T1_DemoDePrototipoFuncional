package com.example.uiii_t1_demodeprototipofuncional.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uiii_t1_demodeprototipofuncional.data.model.JuegoRecomendados

@Composable
fun RecomendadosCard(p: JuegoRecomendados, onClick: (JuegoRecomendados) -> Unit) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick(p) }
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Column {
                Text(text = p.nombre, fontWeight = FontWeight.Bold)
                Text(text = "Categoría: ${p.categoria}")
                Text(text = "Puntuación: ${p.puntuacion}")
            }
        }
    }
}
