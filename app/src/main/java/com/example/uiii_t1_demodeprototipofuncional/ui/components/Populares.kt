package com.example.uiii_t1_demodeprototipofuncional.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.uiii_t1_demodeprototipofuncional.data.model.JuegosPopulares

@Composable
fun JuegosPopulares(p: JuegosPopulares, x: (JuegosPopulares) -> Unit){
    Column {
        Card (
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(30.dp)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(30.dp)) {
                Image(
                    painter = painterResource(p.imageng),
                    contentDescription = "imagen de la persona",
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(30.dp)
                )
                Column {
                    Row {
                        Image(
                            painter = painterResource(p.imagench),
                            contentDescription = "imagen de la persona",
                            modifier = Modifier
                                .fillMaxSize()
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(30.dp)
                        )
                        Column {
                            Text(text = p.nombre, fontWeight = FontWeight.Bold)
                            Text(text = p.precio)
                        }
                    }

                }
            }
        }
    }
}
