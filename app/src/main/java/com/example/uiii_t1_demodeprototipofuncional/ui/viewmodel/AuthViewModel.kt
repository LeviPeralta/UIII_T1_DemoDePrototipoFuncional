package com.example.uiii_t1_demodeprototipofuncional.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var isLogged = mutableStateOf(false)
    var errorMessage = mutableStateOf("")

    // Login hardcodeado (funcional)
    fun login(): Boolean {
        val user = username.value.trim()
        val pass = password.value.trim()

        return if (user == "admin" && pass == "1234") {
            isLogged.value = true
            errorMessage.value = ""
            true
        } else {
            errorMessage.value = "Usuario o contraseña incorrectos"
            false
        }
    }
}
