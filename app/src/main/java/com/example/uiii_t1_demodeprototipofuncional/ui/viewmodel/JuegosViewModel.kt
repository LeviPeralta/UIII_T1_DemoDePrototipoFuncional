package com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.uiii_t1_demodeprototipofuncional.data.model.JuegoRecomendados
import com.example.uiii_t1_demodeprototipofuncional.data.model.JuegosPopulares

class JuegosViewModel : ViewModel() {

    val recomendados = listOf(
        JuegoRecomendados("Elden Ring", "Rol y aventura", 9.5, "eldenring"),
        JuegoRecomendados("Hollow Knight", "Metroidvania", 9.0, "hollowknight"),
        JuegoRecomendados("Celeste", "Plataformas", 8.8, "celeste"),
        JuegoRecomendados("Stardew Valley", "Simulación", 9.2, "stardew"),
        JuegoRecomendados("The Witcher 3", "Acción RPG", 9.8, "witcher3")
    )

    val populares = listOf(
        JuegosPopulares("Minecraft", "Construcción y exploración", 10.0, "minecraft"),
        JuegosPopulares("Fortnite", "Battle Royale", 8.5, "fortnite"),
        JuegosPopulares("Valorant", "Shooter táctico", 8.7, "valorant"),
        JuegosPopulares("GTA V", "Mundo abierto", 9.4, "gtav"),
        JuegosPopulares("Roblox", "Creatividad y comunidad", 8.3, "roblox")
    )
}