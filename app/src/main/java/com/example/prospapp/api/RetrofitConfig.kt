package com.example.prospapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    // URL base da API
    private const val BASE_URL = "https://prospai.azurewebsites.net/"

    // Instância do Retrofit
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // Conversor de JSON
        .build()

    // ClienteApiService - Interface que contém os endpoints
    val clienteApiService: ClienteApiService by lazy {
        retrofit.create(ClienteApiService::class.java)
    }
}
