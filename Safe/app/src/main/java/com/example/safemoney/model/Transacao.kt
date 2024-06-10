package com.example.safemoney.model

import TipoTransacao

data class Transacao(
    val id: Int?,
    val nome: String,
    val data: String,
    val valor: Double,
    val conta: UserContaDTO,
    val categoria: Categoria,
    val tipo: TipoTransacao,
    val fixo: Boolean
)



