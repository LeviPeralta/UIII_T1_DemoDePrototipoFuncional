package com.example.uiii_t1_demodeprototipofuncional.data.model

import androidx.annotation.DrawableRes

data class JuegosPopulares(
    val nombre: String,
    val precio: String,
    @DrawableRes val imageng: Int,
    @DrawableRes val imagench: Int
)