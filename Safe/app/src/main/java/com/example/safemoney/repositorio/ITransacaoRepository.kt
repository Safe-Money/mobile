package com.example.safemoney.repositorio

import com.example.safemoney.model.Transacao
import retrofit2.Response

interface ITransacaoRepository {
    suspend fun adicionarReceita(r: Transacao)
    suspend fun adicionarFixa(r: Transacao)
    suspend fun adicionarDespesa(r: Transacao)
    suspend fun listarTransacoes(id: Int): Response<List<Transacao>>
    suspend fun getGastoCartao(idCartao: Int): Response<List<Transacao>>

}