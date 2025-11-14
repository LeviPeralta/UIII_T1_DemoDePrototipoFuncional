package com.example.uiii_t1_demodeprototipofuncional.data.network

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:5000/"

    val instance: UsuarioApi by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            .create(UsuarioApi::class.java)
    }
}
