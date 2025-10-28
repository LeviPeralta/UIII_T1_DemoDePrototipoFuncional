package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel.JuegosViewModel

@Composable
fun Biblioteca(navController: NavHostController, juegosVM: JuegosViewModel){
    Column (modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ){
        Column {
            Row {
                Text("Biblioteca")

                //Aqui va la opcion de editar
            }
            //Aqui Todos los juegos van en una LazyColumn
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                //No se pueden conectar las cards juegos sin un ViewModel
            }
        }
    }
}
