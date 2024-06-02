package com.example.safemoney.model

import TipoTransacao

data class Receita(
    val id: Int? = null, // ou qualquer outro tipo de ID que esteja usando (Long, String, etc.)
    val nome: String,
    val data: String, // Use o formato de data que o backend espera, geralmente ISO 8601 (yyyy-MM-dd)
    val valor: Double,
    val contaOrigem: UserContaDTO,
    val categoria: Categoria,
    val tipoTransacao: TipoTransacao,
    val fixo: Boolean
)