package com.example.uiii_t1_demodeprototipofuncional.data

import java.io.Serializable

data class Usuario(
    val id: Int = 0,
    val nombre: String,
    val fechaNacimiento: String,
    val correo: String,
    val contrasena: String,
    val telefono: String
) : Serializable
