package com.example.uiii_t1_demodeprototipofuncional.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.ui.components.buttons.Boton

@Composable
fun RecuperaContraaa(navController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Row {
            //Aqui va imagen de logo
        }
        Column (
            verticalArrangement = Arrangement.spacedBy(27.dp)){
            Row {
                Text (text = "Cambiar Contraseña",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp))
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)){
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Correo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)

                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)){
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Contraseña") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)

                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)){
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Confirmar Contraseña") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)

                )
            }
        }
        Column (
            modifier = Modifier
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
        ){
            Boton("Enviar") {

            }
        }
    }
}
