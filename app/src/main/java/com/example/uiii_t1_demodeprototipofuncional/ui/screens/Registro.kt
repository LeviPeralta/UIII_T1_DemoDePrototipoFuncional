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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.uiii_t1_demodeprototipofuncional.ui.components.buttons.Boton

@Composable
fun Registro(navController: NavHostController){
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
            //Aqui va imagen de foto de perfil
        }
        Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
            Row {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Ingresa tu nombre") }
                )
            }
            Row {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Ingresa tu Fecha de nacimiento") }
                )
            }
            Row {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Ingresa tu Correo") }
                )
            }
            Row {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Ingresa tu Contraseña") }
                )
            }
            Row {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Confirma tu Contraseña") }
                )
            }
            Row {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Ingresa tu Numero de telefono") }
                )
            }
        }
        Column (
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
        ){
            Boton("Iniciar sesion con Google") {

            }
            Boton("Iniciar sesion con Correo") {

            }
            Boton("Iniciar sesion") {
                navController.navigate("tienda")

            }
        }
    }
}