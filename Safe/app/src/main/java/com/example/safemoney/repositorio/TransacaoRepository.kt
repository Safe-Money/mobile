package com.example.safemoney.repositorio

import TransacaoService
import android.util.Log
import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.model.Transacao
import retrofit2.Response

class TransacaoRepository : ITransacaoRepository {
    private val transacaoService by lazy{
        Rest.getInstance().create(TransacaoService::class.java)
    }

    override suspend fun adicionarReceita(r: Transacao) {
        transacaoService.adicionarReceita(r)
    }

    override suspend fun adicionarFixa(r: Transacao) {
        transacaoService.adicionarFixa(r)
    }

    override suspend fun adicionarDespesa(r: Transacao) {
        transacaoService.adicionarDespesa(r)
    }

    override suspend fun listarTransacoes(id: Int): Response<List<Transacao>> {
        return transacaoService.listarTransacoes(id)
    }

    override suspend fun getGastoCartao(idCartao: Int): Response<List<Transacao>> {
        return transacaoService.getGastoCartao(idCartao)
    }
}