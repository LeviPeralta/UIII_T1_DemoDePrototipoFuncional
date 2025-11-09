package com.example.uiii_t1_demodeprototipofuncional.data

import android.content.Context

class Repository(context: Context) {
    private val dbHelper = DbHelper(context.applicationContext)

    fun insertUsuario(usuario: Usuario): Long = dbHelper.insertUsuario(usuario)

    fun getUsuarios(): List<Usuario> = dbHelper.getAllUsuarios()
}
