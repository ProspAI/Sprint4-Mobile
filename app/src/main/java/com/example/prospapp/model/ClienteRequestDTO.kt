package com.example.prospapp.model

data class ClienteRequestDTO(
    val nome: String,
    val email: String,
    val telefone: String,
    val segmentoMercado: String,
    val scoreEngajamento: Double
)
