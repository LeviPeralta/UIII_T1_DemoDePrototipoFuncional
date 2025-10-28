package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.data.model.JuegoRecomendados

@Composable
fun Tienda(navController: NavHostController) {
    Column (modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ){

        Row {
            //LOGO
            //Tambien va el menu de usuario lupa y guardados (Aun no existe guardados)
        }
        Column {
            Text("Biblioteca")
        }
        Column (verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
        ){
            Row {
                Text("Populares")
            }

            //Lista de populares (Puede ser en un LazyRow)
        }

        Column {
            Row {
                Text("Recomendados")
            }

            //Otro LazyColumn Con recomendados
        }



    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        //Aqui va un lazy Column con los recomendados, pero solo se puede poner con VeiwModel
    }
}
