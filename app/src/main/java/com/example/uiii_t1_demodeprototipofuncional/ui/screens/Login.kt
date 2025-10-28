package com.example.uiii_t1_demodeprototipofuncional.ui.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import com.example.uiii_t1_demodeprototipofuncional.ui.components.buttons.Linkeado
import com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel.AuthViewModel

@Composable
fun Login(navController: NavHostController, authVM: AuthViewModel)
{
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
                Text("¿Olvidaste tu contraseña?",
                    modifier = Modifier.clickable { navController.navigate("recupera") })
            }
            Row {
                Text("Regístrate",
                    modifier = Modifier.clickable { navController.navigate("registro") })
            }
        }

        Boton ("Iniciar sesión") {
            if (authVM.login()) {
                navController.navigate("tienda")
            }


        }

    }
}