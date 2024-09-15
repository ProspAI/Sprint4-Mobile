package com.example.prospapp.api

import com.example.prospapp.model.ClienteRequestDTO
import com.example.prospapp.model.ClienteResponseDTO
import retrofit2.Response
import retrofit2.http.*

interface ClienteApiService {

    @GET("api/clientes")
    suspend fun getAllClientes(): Response<List<ClienteResponseDTO>>

    @GET("api/clientes/{id}")
    suspend fun getClienteById(@Path("id") id: Long): Response<ClienteResponseDTO>

    @POST("api/clientes")
    suspend fun createCliente(@Body cliente: ClienteRequestDTO): Response<ClienteResponseDTO>

    @PUT("api/clientes/{id}")
    suspend fun updateCliente(@Path("id") id: Long, @Body cliente: ClienteRequestDTO): Response<ClienteResponseDTO>

    @DELETE("api/clientes/{id}")
    suspend fun deleteCliente(@Path("id") id: Long): Response<Void>
}
