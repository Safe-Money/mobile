package com.example.safemoney.model

import UserConta
import Usuario

data class FkUsuario(
    val id: Int
)

data class ContaBanco(
    val id: Int,
    val fkUsuario: FkUsuario
)

data class Cartao(
    val nome: String,
    val bandeira: String,
    val limite: Int,
    val dataVencimento: String ,
    val dataFechamento: String ,
    val conta: ContaBanco
)


data class CartaoGet(
    val nome: String,
    val bandeira: String,
    val limite: Int,
    val vencimento: String ,
    val fechamento: String ,
    val conta: ContaBanco
)