package com.example.uiii_t1_demodeprototipofuncional.data.network

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface UsuarioApi {

    @GET("usuarios")
    fun getUsuarios(): Call<List<Usuario>>

    @Multipart
    @POST("usuarios")
    fun crearUsuario(
        @Part("nombre") nombre: RequestBody,
        @Part("fechaNacimiento") fechaNacimiento: RequestBody,
        @Part("correo") correo: RequestBody,
        @Part("contrasena") contrasena: RequestBody,
        @Part("telefono") telefono: RequestBody
    ): Call<Usuario>

    @Multipart
    @PUT("usuarios/{id}")
    fun actualizarUsuario(
        @Path("id") id: Int,
        @Part("nombre") nombre: RequestBody?,
        @Part("fechaNacimiento") fechaNacimiento: RequestBody?,
        @Part("correo") correo: RequestBody?,
        @Part("contrasena") contrasena: RequestBody?,
        @Part("telefono") telefono: RequestBody?
    ): Call<Usuario>

    @DELETE("usuarios/{id}")
    fun eliminarUsuario(@Path("id") id: Int): Call<Void>
}
