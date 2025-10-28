package com.example.uiii_t1_demodeprototipofuncional.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uiii_t1_demodeprototipofuncional.data.model.JuegoRecomendados

@Composable
fun Recomendados(p: JuegoRecomendados, x: (JuegoRecomendados) -> Unit){
    Column{
        Card {
            Row (verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(30.dp),) {
                Image(
                    painter = painterResource(p.imagen),
                    contentDescription = "imagen de la persona"
                )
                Column {
                    Text(text = p.nombre, fontWeight = FontWeight.Bold)
                    Text(text = p.precio)
                }
            }
        }
    }
}

