package com.example.uiii_t1_demodeprototipofuncional.data.model

import androidx.annotation.DrawableRes

data class JuegoRecomendados (
    val nombre: String,
    val precio: String,
    @DrawableRes val imagen: Int
)