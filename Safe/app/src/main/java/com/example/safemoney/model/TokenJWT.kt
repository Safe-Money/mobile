package com.example.safemoney.model

data class TokenJWT (
    val id: Int,
    val nome: String,
    val email: String,
    val token: String
)