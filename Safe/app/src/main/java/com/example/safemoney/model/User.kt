package com.example.safemoney.model


data class User(
    val nome: String,
    val email: String,
    val senha: String?

)


data class Senha(
    val senha: String,
    )

