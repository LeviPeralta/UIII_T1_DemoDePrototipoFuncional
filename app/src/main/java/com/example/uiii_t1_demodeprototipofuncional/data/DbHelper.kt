package com.example.uiii_t1_demodeprototipofuncional.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, "usuarios.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
        CREATE TABLE usuarios (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT,
            fechaNacimiento TEXT,
            correo TEXT,
            contrasena TEXT,
            telefono TEXT
        )
    """.trimIndent()
        db.execSQL(createTable)

        db.execSQL("INSERT INTO usuarios (nombre, fechaNacimiento, correo, contrasena, telefono) VALUES ('Juan Pérez', '2000-05-12', 'juan@gmail.com', '1234', '5551112222')")
        db.execSQL("INSERT INTO usuarios (nombre, fechaNacimiento, correo, contrasena, telefono) VALUES ('María López', '1999-08-25', 'maria@gmail.com', 'abcd', '5552223333')")
        db.execSQL("INSERT INTO usuarios (nombre, fechaNacimiento, correo, contrasena, telefono) VALUES ('Carlos Díaz', '2001-03-15', 'carlos@gmail.com', 'qwerty', '5553334444')")
        db.execSQL("INSERT INTO usuarios (nombre, fechaNacimiento, correo, contrasena, telefono) VALUES ('Lucía Gómez', '1998-12-10', 'lucia@gmail.com', 'password', '5554445555')")
        db.execSQL("INSERT INTO usuarios (nombre, fechaNacimiento, correo, contrasena, telefono) VALUES ('Ana Torres', '2002-09-01', 'ana@gmail.com', '0000', '5555556666')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    // Crear (Insert)
    fun insertUsuario(usuario: Usuario): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("nombre", usuario.nombre)
            put("fechaNacimiento", usuario.fechaNacimiento)
            put("correo", usuario.correo)
            put("contrasena", usuario.contrasena)
            put("telefono", usuario.telefono)
        }

        // Inserta y retorna el ID del nuevo registro
        val id = db.insert("usuarios", null, values)
        db.close()
        return id
    }


    // Leer (Read)
    fun getAllUsuarios(): List<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuarios", null)
        if (cursor.moveToFirst()) {
            do {
                usuarios.add(
                    Usuario(
                        id = cursor.getInt(0),
                        nombre = cursor.getString(1),
                        fechaNacimiento = cursor.getString(2),
                        correo = cursor.getString(3),
                        contrasena = cursor.getString(4),
                        telefono = cursor.getString(5)
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return usuarios
    }

    // Actualizar (Update)
    fun updateUsuario(usuario: Usuario): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("nombre", usuario.nombre)
            put("fechaNacimiento", usuario.fechaNacimiento)
            put("correo", usuario.correo)
            put("contrasena", usuario.contrasena)
            put("telefono", usuario.telefono)
        }
        val rows = db.update("usuarios", values, "id = ?", arrayOf(usuario.id.toString()))
        db.close()
        return rows
    }

    // Eliminar (Delete)
    fun deleteUsuario(id: Int): Int {
        val db = writableDatabase
        val rows = db.delete("usuarios", "id = ?", arrayOf(id.toString()))
        db.close()
        return rows
    }
}
