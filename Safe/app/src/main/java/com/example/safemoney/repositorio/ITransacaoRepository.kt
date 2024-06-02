package com.example.safemoney.repositorio

import com.example.safemoney.model.Receita

interface ITransacaoRepository {
    suspend fun adicionarReceita(r: Receita)
    suspend fun adicionarReceitaFixa(r: Receita)
}