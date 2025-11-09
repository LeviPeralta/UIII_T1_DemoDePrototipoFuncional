package com.example.uiii_t1_demodeprototipofuncional.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class Usuario(
    var id: Long = 0L,
    var nombre: String,
    var fechaNacimiento: String,
    var correo: String,
    var contrasena: String,
    var telefono: String
)

class DbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        const val DB_NAME = "demo_prototipo.db"
        const val DB_VERSION = 2 // <-- súbelo para que se regenere la DB
        const val TABLE_USER = "usuarios"

        const val COL_ID = "id"
        const val COL_NOMBRE = "nombre"
        const val COL_FECHA = "fechaNacimiento"
        const val COL_CORREO = "correo"
        const val COL_CONTRASENA = "contrasena"
        const val COL_TELEFONO = "telefono"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_USER (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NOMBRE TEXT NOT NULL,
                $COL_FECHA TEXT,
                $COL_CORREO TEXT,
                $COL_CONTRASENA TEXT,
                $COL_TELEFONO TEXT
            );
        """.trimIndent()
        db.execSQL(createTable)

        // Insertar 5 registros de ejemplo
        val defaults = listOf(
            Usuario(nombre = "Juan Pérez", fechaNacimiento = "1999-03-15", correo = "juan@correo.com", contrasena = "1234", telefono = "5551234567"),
            Usuario(nombre = "Ana López", fechaNacimiento = "2000-06-22", correo = "ana@correo.com", contrasena = "abcd", telefono = "5552345678"),
            Usuario(nombre = "Carlos Ruiz", fechaNacimiento = "1998-09-01", correo = "carlos@correo.com", contrasena = "xyz", telefono = "5553456789"),
            Usuario(nombre = "María Díaz", fechaNacimiento = "1997-12-11", correo = "maria@correo.com", contrasena = "12345", telefono = "5554567890"),
            Usuario(nombre = "Laura Torres", fechaNacimiento = "2001-01-05", correo = "laura@correo.com", contrasena = "qwerty", telefono = "5555678901")
        )

        defaults.forEach { insertUsuario(db, it) }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        onCreate(db)
    }

    private fun insertUsuario(db: SQLiteDatabase, usuario: Usuario) {
        val values = ContentValues().apply {
            put(COL_NOMBRE, usuario.nombre)
            put(COL_FECHA, usuario.fechaNacimiento)
            put(COL_CORREO, usuario.correo)
            put(COL_CONTRASENA, usuario.contrasena)
            put(COL_TELEFONO, usuario.telefono)
        }
        db.insert(TABLE_USER, null, values)
    }

    fun insertUsuario(usuario: Usuario): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_NOMBRE, usuario.nombre)
            put(COL_FECHA, usuario.fechaNacimiento)
            put(COL_CORREO, usuario.correo)
            put(COL_CONTRASENA, usuario.contrasena)
            put(COL_TELEFONO, usuario.telefono)
        }
        val id = db.insert(TABLE_USER, null, values)
        db.close()
        return id
    }

    fun getAllUsuarios(): List<Usuario> {
        val lista = mutableListOf<Usuario>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_USER", null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Usuario(
                        id = cursor.getLong(cursor.getColumnIndexOrThrow(COL_ID)),
                        nombre = cursor.getString(cursor.getColumnIndexOrThrow(COL_NOMBRE)),
                        fechaNacimiento = cursor.getString(cursor.getColumnIndexOrThrow(COL_FECHA)),
                        correo = cursor.getString(cursor.getColumnIndexOrThrow(COL_CORREO)),
                        contrasena = cursor.getString(cursor.getColumnIndexOrThrow(COL_CONTRASENA)),
                        telefono = cursor.getString(cursor.getColumnIndexOrThrow(COL_TELEFONO))
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lista
    }
}
