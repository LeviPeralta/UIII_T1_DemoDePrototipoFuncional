package com.example.uiii_t1_demodeprototipofuncional.data.network

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiService {

    @GET("usuarios")
    fun getUsuarios(): Call<List<Usuario>>

    @POST("usuarios")
    fun createUsuario(@Body usuario: Usuario): Call<Usuario>

    @PUT("usuarios/{id}")
    fun updateUsuario(@Path("id") id: Int, @Body usuario: Usuario): Call<Usuario>

    @DELETE("usuarios/{id}")
    fun deleteUsuario(@Path("id") id: Int): Call<Void>
}
