package com.example.safemoney.repositorio

import TransacaoService
import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.model.Receita

class TransacaoRepository : ITransacaoRepository {
    private val transacaoService by lazy{
        Rest.getInstance().create(TransacaoService::class.java)
    }

    override suspend fun adicionarReceita(r: Receita) {
        transacaoService.adicionarReceita(r)
    }

    override suspend fun adicionarReceitaFixa(r: Receita) {
        transacaoService.adicionarReceitaFixa(r)
    }
}