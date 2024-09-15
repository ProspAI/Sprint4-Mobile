package com.example.prospapp.model

data class ClienteResponseDTO(
    val id: Long,
    val nome: String,
    val email: String,
    val telefone: String,
    val segmentoMercado: String,
    val scoreEngajamento: Double,
    val dataCriacao: String
)
