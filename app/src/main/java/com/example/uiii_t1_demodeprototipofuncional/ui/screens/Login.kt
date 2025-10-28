package com.example.uiii_t1_demodeprototipofuncional.ui.screens


import android.annotation.SuppressLint
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
import com.example.uiii_t1_demodeprototipofuncional.ui.theme.components.buttons.Boton
import com.example.uiii_t1_demodeprototipofuncional.ui.theme.components.buttons.Linkeado

@Composable
fun Login(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        //Aqui va logo

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

        Column (modifier = Modifier
            .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)){
            Row {
                Linkeado ("¿Has olvidado la contraseña?") { }
            }
            Row {
                Linkeado ("¿No tienes cuenta? Regístrate") {

                }
            }
        }

        Boton ("Iniciar sesión") {

        }

    }
}