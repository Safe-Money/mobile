package com.example.safemoney.model

data class Objetivos(
    val id: Int? = null,
    val nome: String,
    val urlImagem: String,
    val dataInicio: String,
    val ultimoDeposito: String,
    val dataTermino: String,
    val concluida: Int,
    val valorInvestido: Double,
    val valorFinal: Double,
    val fkUsuario: FkUsuario12
)






data class FkUsuario12(
    val id: Int
)